package cn.ipman.sc;

import cn.ipman.sc.api.model.User;
import cn.ipman.sc.contract.HelloApiServiceClient;
import cn.ipman.sc.contract.UserApiServiceClient;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.ipman.sc")
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

    @Autowired
    HelloApiServiceClient helloService;

    @Autowired
    UserApiServiceClient userService;

    @Autowired
    ApplicationContext context;


    // 服务发现,获取provider元数据
    @Autowired
    DiscoveryClient discoveryClient;

    // RestTemplate, 用于测试Ribbon
    @Autowired
    RestTemplate restTemplate;


    @Bean
    ApplicationRunner runner() {
        return args -> {
            System.out.println("helloService-consumer started");

            for (int i = 0; i < 10; i++) {
                testOpenFeign(); // 测试openfeign
            }

            // 扫描被标记 @OpenFeignClient 的Bean
            scanServiceClientBean();
            
            // 打印从 Nacos 获取Provider的实例,以及元数据
            printFromNacosProviderInstances();
            
            // 测试手动通过 Nacos 获取的Provider的实例, 通过restTemplate, 手动调用
            testRestTemplateToNacosProviderInstance();

            // 测试通过 Ribbon + RestTemplate + Nacos 访问Provider实例
            testRibbonLoadBalancedBanByRestTemplate();

        };
    }

    private void testRibbonLoadBalancedBanByRestTemplate() {
        // 测试Ribbon
        for (int i = 0; i < 10; i++) {
            // helloService, 会被转换成nacos的服务地址
            String res2 = this.restTemplate.getForObject(
                    "http://helloService/api/user/list?name=ipman", String.class);
            System.out.println("==> ribbon.url res: " + res2);
        }
    }

    private void testRestTemplateToNacosProviderInstance() {
        List<ServiceInstance> serviceInstanceList1 = discoveryClient.getInstances("helloService");
        // 随机访问
        List<String> urls = serviceInstanceList1.stream()
                .map(instance -> instance.getUri() + "/api/user/list?name=ipman")
                .toList();
        for (int i = 0; i < 10; i++) {
            int random = ThreadLocalRandom.current().nextInt(urls.size());
            RestTemplate restTemplate = new RestTemplate();
            String url1 = urls.get(random);
            String res1 = restTemplate.getForObject(url1, String.class);
            System.out.println("==> random.url to : " + url1 + " , res: " + res1);
        }
    }

    private void printFromNacosProviderInstances() {
        // 测试从,注册中心拿到provider元数据
        // test get nacos instances and call rest template...
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("helloService");
        System.out.println("===>  get instances: " + JSON.toJSONString(serviceInstanceList));
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            String url = serviceInstance.getUri() + "/api/user/list?name=ipman";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class, 1);
            System.out.println("===> call instance: " + JSON.toJSONString(result));
        }
    }

    private void scanServiceClientBean() {
        // @FeignClient(value = "helloService", contextId = "hello") ,
        // 添加:contextId , 避免FeignClientSpecification冲突
        context.getBeansWithAnnotation(FeignClient.class).forEach((k, v) -> {
            System.out.println(" FeignClient ==> " + k + " : " + v);
        });
        System.out.println(Arrays.toString(context.getBeanNamesForType(HelloApiServiceClient.class)));
        System.out.println(Arrays.toString(context.getBeanNamesForType(UserApiServiceClient.class)));
        Arrays.stream(context.getBeanDefinitionNames())
                .filter(x -> x.contains("hello") || x.contains("user")).forEach(System.out::println);
        System.out.println(context.getBean("user.FeignClientSpecification"));
        System.out.println(context.getBean("userFeignClient"));
    }
    

    private void testOpenFeign() {
        String hello = helloService.hi();
        System.out.println("==> helloService.hello : " + hello);
        hello = helloService.a("ipman");
        System.out.println("==> helloService.a : " + hello);
        hello = helloService.b("vipman");
        System.out.println("==> helloService.b : " + hello);

        hello = helloService.c("svipman");
        System.out.println("==> helloService.c : " + hello);

        User user123 = userService.findById(123);
        System.out.println("==> helloService.list : " + user123);
    }


}

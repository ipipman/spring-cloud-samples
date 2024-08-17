package cn.ipman.sc.consumer;

import cn.ipman.sc.api.model.User;
import cn.ipman.sc.contract.HelloApiServiceClient;
import cn.ipman.sc.contract.UserApiServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

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

    @Bean
    ApplicationRunner runner() {
        return args -> {
            System.out.println("helloService-consumer started");

            for (int i = 0; i < 10; i++) {
                test();
            }

            // @FeignClient(value = "helloService", contextId = "hello") ,
            // 添加:contextId , 避免FeignClientSpecification冲突
            context.getBeansWithAnnotation(FeignClient.class).forEach((k, v) -> {
                System.out.println(" FeignClient ==> " + k + " : " + v);
            });
            System.out.println(Arrays.toString(context.getBeanNamesForType(HelloApiServiceClient.class)));
            System.out.println(Arrays.toString(context.getBeanNamesForType(UserApiServiceClient.class)));
            Arrays.stream(context.getBeanDefinitionNames())
                    .filter(x -> x.contains("hello")||x.contains("user")).forEach(System.out::println);
            System.out.println(context.getBean("user.FeignClientSpecification"));
            System.out.println(context.getBean("userFeignClient"));

        };
    }

    private void test() {
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

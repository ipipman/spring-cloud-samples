package cn.ipman.sc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("cn.ipman.sc")
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

    @Autowired
    DemoClient helloService;

    @Bean
    ApplicationRunner runner(){
        return args -> {

            String hello = helloService.hello();
            System.out.println("===> helloService.hello : " + hello);

            String a = helloService.a("ipman");
            System.out.println("===> helloService.hello.a : " + a);

            String b = helloService.b("vipman");
            System.out.println("===> helloService.hello.b : " + b);


            // ===
            String list = helloService.list("ipman");
            System.out.println("===> helloService.hello.a : " + list);

            String find = helloService.find("vipman");
            System.out.println("===> helloService.hello.b : " + find);
        };
    }

}

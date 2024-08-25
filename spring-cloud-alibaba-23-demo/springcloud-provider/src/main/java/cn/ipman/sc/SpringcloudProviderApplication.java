package cn.ipman.sc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class SpringcloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderApplication.class, args);
    }


    @Value("${a.b}")
    private String ab;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println("springcloud-provider started: " + ab);
        };
    }
}

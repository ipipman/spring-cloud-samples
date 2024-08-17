package cn.ipman.prewarmup;

import cn.ipman.prewarmup.utils.HttpUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrewarmupApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrewarmupApplication.class, args);
    }


    @Bean
    ApplicationRunner runner() {
        return args -> {
//            // System.out.println("Hello World!");
//            // 模拟httpclient http://localhost:8080/hello
            System.out.println("===>> 预热:");
            String ret = HttpUtils.get("http://localhost:8081/hello");
            System.out.println(ret);

            for (int i = 0; i < 1000; i++) {
                try {
                    HttpUtils.get("https://profile-counter.glitch.me/ipipman/count.svg");
                }catch (Exception e){

                }

            }
        };
    }
}

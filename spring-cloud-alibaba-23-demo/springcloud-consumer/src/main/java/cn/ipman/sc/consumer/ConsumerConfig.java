package cn.ipman.sc.consumer;

import cn.ipman.sc.request.IMRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 20:32
 */
@Configuration
public class ConsumerConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new IMRequestInterceptor();
    }

}

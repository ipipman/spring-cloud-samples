package cn.ipman.sc.consumer.request;

import cn.ipman.sc.consumer.ribbon.HelloApiCustomRule;
import com.netflix.loadbalancer.IRule;
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
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new IMRequestInterceptor();
    }

}

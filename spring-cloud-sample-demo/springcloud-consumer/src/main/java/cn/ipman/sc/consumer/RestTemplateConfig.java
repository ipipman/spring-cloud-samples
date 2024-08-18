package cn.ipman.sc.consumer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 19:42
 */
@Configuration
public class RestTemplateConfig {

    // 在spring容器中，创建一个对象，类型RestTemplate；名称/ID是：restTemplate
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate =  new RestTemplate();
        restTemplate.setInterceptors(List.of(new LoggingInterceptor()));
        return restTemplate;
    }

    // 实现 ClientHttpRequestInterceptor 接口
    @SuppressWarnings("all")
    class LoggingInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                throws IOException {
            // 记录请求 URL
            System.out.println("ribbon.url to: " + request.getURI());
            System.out.println("ribbon.url to: " + request);
            return execution.execute(request, body);
        }
    }
}

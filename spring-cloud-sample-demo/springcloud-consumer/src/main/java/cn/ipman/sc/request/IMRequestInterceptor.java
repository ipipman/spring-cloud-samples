package cn.ipman.sc.request;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 20:16
 */
public class IMRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("X-Request-Id", "123");
        requestTemplate.header("X-Request-appId", "456");
        requestTemplate.header("X-Request-Type", "IMCloud");
        requestTemplate.header("X-Request-Version", "1.0");
        requestTemplate.header("X-Request-Client", "OpenFeign");
    }
}

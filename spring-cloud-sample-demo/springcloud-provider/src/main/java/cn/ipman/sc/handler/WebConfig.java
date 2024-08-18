package cn.ipman.sc.handler;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 20:26
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(new IMRequestHandlerInterceptor())
                .addPathPatterns("/**");
    }
}

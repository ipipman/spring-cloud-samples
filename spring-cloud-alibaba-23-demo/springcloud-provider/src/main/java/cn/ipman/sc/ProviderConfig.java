package cn.ipman.sc;

import cn.ipman.sc.handler.IMRequestHandlerInterceptor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProviderConfig implements WebMvcConfigurer {

    @Autowired
    IMRequestHandlerInterceptor requestHandlerInterceptor;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        String[] excludes = new String[]
                {"/*.html", "/html/**", "/js/**", "/css/**", "/images/**"};
        registry.addInterceptor(requestHandlerInterceptor)
                .addPathPatterns("/**").excludePathPatterns(excludes);
    }
}

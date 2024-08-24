package cn.ipman.sc.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/24 19:30
 */
public class IMApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("==>> IMApplicationContextInitializer ...");
        String env = System.getProperty("env", "dev").toLowerCase();
        applicationContext.getEnvironment().setActiveProfiles(env);
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        propertySources.addFirst(new MapPropertySource("ipman-map-property-source",
                Map.of("a.b", "ipman")));

    }
}

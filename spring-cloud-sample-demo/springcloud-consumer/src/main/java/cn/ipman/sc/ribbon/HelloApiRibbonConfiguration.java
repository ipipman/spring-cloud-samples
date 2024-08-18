package cn.ipman.sc.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 21:34
 */
@Configuration
@RibbonClient(name = "helloService", configuration = RibbonConfiguration.class)
public class HelloApiRibbonConfiguration {
}

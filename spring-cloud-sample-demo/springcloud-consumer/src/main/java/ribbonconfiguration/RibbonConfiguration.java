package ribbonconfiguration;

import cn.ipman.sc.consumer.ribbon.HelloApiCustomRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 21:30
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule iRule() {
        return new HelloApiCustomRule();
    }
}

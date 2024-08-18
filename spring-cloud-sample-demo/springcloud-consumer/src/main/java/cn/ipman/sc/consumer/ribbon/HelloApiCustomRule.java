package cn.ipman.sc.consumer.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/18 21:51
 */
public class HelloApiCustomRule extends AbstractLoadBalancerRule {


    @Override
    public Server choose(Object key) {
        ILoadBalancer lb = getLoadBalancer();
        if (lb == null) {
            return null;
        }

        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            // 自定义选择逻辑
            server = lb.chooseServer(key);

            if (server == null) {
                Thread.yield();
            }
        }

        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}

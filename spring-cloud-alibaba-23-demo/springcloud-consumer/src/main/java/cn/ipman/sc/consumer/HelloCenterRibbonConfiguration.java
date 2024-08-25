package cn.ipman.sc.consumer;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

import ribbonconfiguration.RibbonConfiguration;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/25 20:43
 */
@LoadBalancerClient(name = "helloService", configuration = RibbonConfiguration.class)
public class HelloCenterRibbonConfiguration {
}

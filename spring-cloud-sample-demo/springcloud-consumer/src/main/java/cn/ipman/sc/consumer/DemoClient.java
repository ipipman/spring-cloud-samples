package cn.ipman.sc.consumer;

import cn.ipman.sc.contract.HelloServiceClient;
import cn.ipman.sc.contract.UserServiceClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "helloService")
public interface DemoClient extends HelloServiceClient {
}

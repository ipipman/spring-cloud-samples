package cn.ipman.sc.contract;

import cn.ipman.sc.api.service.HelloApiService;
import cn.ipman.sc.request.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:36
 */
@FeignClient(value = "helloService", contextId = "hello", configuration = FeignConfig.class)
public interface HelloApiServiceClient extends HelloApiService {

}

package cn.ipman.sc.contract;

import cn.ipman.sc.api.service.UserApiService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:36
 */
@FeignClient(value = "helloService", contextId = "user")
public interface UserApiServiceClient extends UserApiService {


}

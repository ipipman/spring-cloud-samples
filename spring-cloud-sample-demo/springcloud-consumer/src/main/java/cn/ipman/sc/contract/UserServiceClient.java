package cn.ipman.sc.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:36
 */
public interface UserServiceClient {

    @GetMapping("/api/user/list")
    String list(@RequestParam("name") String name);

    @GetMapping("/api/user/find")
    String find(@RequestParam("name") String name);

}

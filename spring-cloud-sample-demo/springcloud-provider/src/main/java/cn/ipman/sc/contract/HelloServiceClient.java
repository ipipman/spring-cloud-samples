package cn.ipman.sc.contract;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:36
 */

public interface HelloServiceClient {

    @GetMapping("/api/hello")
    String hello();

    @GetMapping("/api/a")
    String a(@RequestParam("name") String name);

    @GetMapping("/api/b")
    String b(@RequestParam("name") String name);

}

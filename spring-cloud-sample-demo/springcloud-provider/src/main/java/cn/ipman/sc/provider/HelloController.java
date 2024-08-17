package cn.ipman.sc.provider;

import cn.ipman.sc.contract.HelloServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:19
 */
@RestController
public class HelloController implements HelloServiceClient {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/api/a")
    public String a(@RequestParam("name") String name) {
        return "hello a," + name;
    }

    @GetMapping("/api/b")
    public String b(@RequestParam("name") String name) {
        return "hello b," + name;
    }

}

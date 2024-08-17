package cn.ipman.sc.provider;

import cn.ipman.sc.contract.UserServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description for this class
 *
 * @Author IpMan
 * @Date 2024/8/10 20:51
 */
@RestController
public class UserController implements UserServiceClient {

    @GetMapping("/api/user/list")
    public String list(@RequestParam("name") String name){
        return "user list " + name;
    }

    @GetMapping("/api/user/find")
    public String find(@RequestParam("name") String name){
        return "find list " + name;
    }
}

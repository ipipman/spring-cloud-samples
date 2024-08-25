package cn.ipman.sc.api.service;

import cn.ipman.sc.api.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@RequestMapping("/api")
public interface UserApiService {

    @GetMapping("/api/user/list")
    List<User> list(@RequestParam("name") String name);

    @GetMapping("/api/user/find")
    User findById(@RequestParam("id") long id);
}

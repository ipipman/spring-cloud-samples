package cn.ipman.prewarmup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 输出 hello,world
    @GetMapping("/hello")
    public String hello() {
        return "hello,world";
    }

}

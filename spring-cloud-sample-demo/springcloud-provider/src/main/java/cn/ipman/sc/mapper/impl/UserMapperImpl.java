package cn.ipman.sc.mapper.impl;

import cn.ipman.sc.api.model.User;
import cn.ipman.sc.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserMapperImpl implements UserMapper {

    public List<User> list(String name){
        return List.of(new User(1, name + "01", 21),
                new User(2, name + "02", 22));
    }

    public User findById(long id) {
        return new User(id, "ipman" + id, 20);
    }
}

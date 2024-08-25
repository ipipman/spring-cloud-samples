package cn.ipman.sc.service.impl;

import cn.ipman.sc.api.model.User;
import cn.ipman.sc.mapper.UserMapper;
import cn.ipman.sc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> list(String name){
        return userMapper.list(name);
    }

    public User findById(long id) {
        return userMapper.findById(id);
    }

}

package cn.ipman.sc.service;


import cn.ipman.sc.api.model.User;

import java.util.List;


public interface UserService {

    List<User> list(String name);
    User findById(long id);

}

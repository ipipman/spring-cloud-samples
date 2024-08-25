package cn.ipman.sc.mapper;


import cn.ipman.sc.api.model.User;

import java.util.List;


public interface UserMapper {

    List<User> list(String name);

    User findById(long id);

}

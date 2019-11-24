package com.guoguo.ningxing.dao.user;

import com.guoguo.ningxing.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User getUserById(@Param("id") Long id);

    void addUser(User user);

    void updateUserById(User user);

    void deleteUserById(@Param("id") Long id);

    List<User> getUserList();

    User getUserByName(@Param("name") String name);
}

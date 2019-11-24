package com.guoguo.ningxing.service.user;

import com.github.pagehelper.PageHelper;
import com.guoguo.ningxing.dao.user.UserDao;
import com.guoguo.ningxing.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private HttpSession session;

    public boolean getUserByName(String name, String password) {
        User user = userDao.getUserByName(name);
        if (user != null) {
            if (user.getPassword().equalsIgnoreCase(password)) {
                session.setAttribute("guse",user);
                return true;
            }
        }
        return false;
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void addUser(User user) {
        Date date = new Date();
        user.setAddTime(date);
        user.setUpdateTime(date);
        userDao.addUser(user);
    }

    public void updateUserById(User user) {
        user.setUpdateTime(new Date());
        userDao.updateUserById(user);
    }

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    public List<User> getUserList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return userDao.getUserList();
    }
}

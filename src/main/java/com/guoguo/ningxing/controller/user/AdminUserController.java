package com.guoguo.ningxing.controller.user;

import com.github.pagehelper.PageInfo;
import com.guoguo.ningxing.entity.user.User;
import com.guoguo.ningxing.service.user.UserService;
import com.guoguo.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam(required = false, defaultValue = "0") Integer pageNum) {
        List<User> proList = userService.getUserList(pageNum);
        PageInfo<User> pageInfo = new PageInfo<>(proList);
        request.setAttribute("pageInfo", pageInfo);
        return "user/list";
    }

    @RequestMapping("/edit")
    public String edit(Long id, HttpServletRequest request) {
        if (id != null) {
            User user = userService.getUserById(id);
            request.setAttribute("user", user);
        }
        return "user/edit";
    }

    @RequestMapping("/info")
    public String info(Long id, HttpServletRequest request) {
        User user = userService.getUserById(id);
        request.setAttribute("user", user);
        return "user/info";
    }

    @RequestMapping("/ajax/save")
    @ResponseBody
    public Json save(User user) {
        if (user.getId() != null) {
            userService.updateUserById(user);
        } else {
            userService.addUser(user);
        }
        return Json.jsonTrue();
    }

    @RequestMapping("/ajax/del")
    @ResponseBody
    public Json del(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return Json.jsonTrue();
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/ajax/login")
    @ResponseBody
    public Json login(@RequestParam("name") String name, @RequestParam("password") String password) {
        boolean b = userService.getUserByName(name, password);
        if (b) {
            return Json.jsonTrue("登录成功");
        }
        return Json.jsonFalse("用户名或密码错误");
    }

    @RequestMapping("/exit")
    public String exit() {
        session.removeAttribute("guse");
        return "redirect:/login";
    }

    @RequestMapping("/turn")
    public String turn(){
        return "turn";
    }
}

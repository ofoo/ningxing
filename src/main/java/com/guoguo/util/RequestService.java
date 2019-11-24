package com.guoguo.util;

import com.guoguo.ningxing.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class RequestService {
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取登录用户id
     *
     * @return
     */
    public long getUseId() {
        HttpSession session = request.getSession();
        User use = (User) session.getAttribute("guse");
        if (use != null) {
            return use.getId();
        }
        return 0;
    }
}

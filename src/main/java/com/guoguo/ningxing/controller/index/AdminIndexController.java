package com.guoguo.ningxing.controller.index;

import com.guoguo.config.ProjectProperties;
import com.guoguo.ningxing.entity.*;
import com.guoguo.ningxing.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class AdminIndexController {

    /**
     * 后台首页
     *
     * @param request
     * @param pageNum
     * @return
     */
    @RequestMapping("/admin/index")
    public String adminIndex(HttpServletRequest request, @RequestParam(required = false, defaultValue = "0") Integer pageNum) {
        return "admin/index";
    }
}

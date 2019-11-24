package com.guoguo.ningxing.controller.teacher;

import com.github.pagehelper.PageInfo;
import com.guoguo.ningxing.entity.teacher.Teacher;
import com.guoguo.ningxing.service.teacher.TeacherService;
import com.guoguo.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/front")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacherList")
    public String teacherList(HttpServletRequest request, @RequestParam(required = false, defaultValue = "0") Integer pageNum) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getParameter("name"));
        List<Teacher> proList = teacherService.getTeacherList(teacher, pageNum);
        PageInfo<Teacher> pageInfo = new PageInfo<>(proList);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("name", teacher.getName());

        String type = request.getParameter("type");
        if (type == null) {
            type = "add";
        }
        request.setAttribute("type", type);
        return "front/teacher/teacherList";
    }
}

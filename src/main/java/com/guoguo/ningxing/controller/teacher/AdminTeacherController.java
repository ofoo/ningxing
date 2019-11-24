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
@RequestMapping("/admin")
public class AdminTeacherController {
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
        return "admin/teacher/teacherList";
    }

    @RequestMapping("/teacherModify")
    public String teacherModify(Long id, HttpServletRequest request) {
        if (id != null) {
            Teacher teacher = teacherService.getTeacherById(id);
            request.setAttribute("teacher", teacher);
        }
        return "admin/teacher/teacherModify";
    }

    @RequestMapping("/ajax/teacherSave")
    @ResponseBody
    public Json teacherSave(Teacher teacher) {
        if (teacher.getId() != null) {
            teacherService.updateTeacherById(teacher);
        } else {
            teacherService.addTeacher(teacher);
        }
        return Json.jsonTrue();
    }

    @RequestMapping("/ajax/teacherDelete")
    @ResponseBody
    public Json teacherDelete(@RequestParam("ids") List<Long> ids) {
        System.out.println(ids);
        teacherService.deleteTeacherByIds(ids);
        return Json.jsonTrue();
    }
}

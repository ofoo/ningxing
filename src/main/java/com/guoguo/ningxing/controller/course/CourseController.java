package com.guoguo.ningxing.controller.course;

import com.github.pagehelper.PageInfo;
import com.guoguo.ningxing.entity.course.Course;
import com.guoguo.ningxing.service.course.CourseService;
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
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courseList")
    public String courseList(HttpServletRequest request, @RequestParam(required = false, defaultValue = "0") Integer pageNum) {
        Course course = new Course();
        course.setName(request.getParameter("name"));
        List<Course> proList = courseService.getCourseList(course, pageNum);
        PageInfo<Course> pageInfo = new PageInfo<>(proList);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("name", course.getName());

        String type = request.getParameter("type");
        if (type == null) {
            type = "add";
        }
        request.setAttribute("type", type);
        return "front/course/courseList";
    }
}

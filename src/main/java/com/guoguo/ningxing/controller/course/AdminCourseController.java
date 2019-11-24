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
@RequestMapping("/admin")
public class AdminCourseController {
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
        return "admin/course/courseList";
    }

    @RequestMapping("/courseModify")
    public String courseModify(Long id, HttpServletRequest request) {
        if (id != null) {
            Course course = courseService.getCourseById(id);
            request.setAttribute("course", course);
        }
        return "admin/course/courseModify";
    }

    @RequestMapping("/ajax/courseSave")
    @ResponseBody
    public Json courseSave(Course course) {
        if (course.getId() != null) {
            courseService.updateCourseById(course);
        } else {
            courseService.addCourse(course);
        }
        return Json.jsonTrue();
    }

    @RequestMapping("/ajax/courseDelete")
    @ResponseBody
    public Json courseDelete(@RequestParam("ids") List<Long> ids) {
        System.out.println(ids);
        courseService.deleteCourseByIds(ids);
        return Json.jsonTrue();
    }
}

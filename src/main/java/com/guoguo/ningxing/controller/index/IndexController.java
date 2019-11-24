package com.guoguo.ningxing.controller.index;

import com.guoguo.config.ProjectProperties;
import com.guoguo.ningxing.entity.banner.Banner;
import com.guoguo.ningxing.entity.company.Company;
import com.guoguo.ningxing.entity.course.Course;
import com.guoguo.ningxing.entity.record.Record;
import com.guoguo.ningxing.entity.teacher.Teacher;
import com.guoguo.ningxing.service.banner.BannerService;
import com.guoguo.ningxing.service.company.CompanyService;
import com.guoguo.ningxing.service.course.CourseService;
import com.guoguo.ningxing.service.record.RecordService;
import com.guoguo.ningxing.service.teacher.TeacherService;
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
public class IndexController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private ProjectProperties projectProperties;

    @RequestMapping("/")
    public String index(HttpServletRequest request, @RequestParam(required = false, defaultValue = "0") Integer pageNum) {
        log.info("fileRoot: " + projectProperties.getFileRoot());
        Banner banner = bannerService.getBanner();
        Company profile = companyService.getCompany(1);
        Company about = companyService.getCompany(2);
        List<Course> courseList = courseService.getCourseByNum(8);
        List<Teacher> teacherList = teacherService.getTeacherByNum(8);
        request.setAttribute("banner", banner);
        request.setAttribute("profile", profile);
        request.setAttribute("about", about);
        request.setAttribute("courseList", courseList);
        request.setAttribute("teacherList", teacherList);

        Record record = recordService.getRecordByAddTime(new Date());
        if (record == null) {
            record = new Record();
            record.setType(1);
            record.setCount(1L);
            record.setAddTime(new Date());
            recordService.addRecord(record);
        } else {
            record.setCount(record.getCount() + 1);
            recordService.updateRecordById(record);
        }
        return "index";
    }
}

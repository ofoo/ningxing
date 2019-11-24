package com.guoguo.ningxing.service.course;

import com.github.pagehelper.PageHelper;
import com.guoguo.ningxing.dao.course.CourseDao;
import com.guoguo.ningxing.entity.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    public void addCourse(Course course) {
        Date date = new Date();
        course.setAddTime(date);
        course.setUpdateTime(date);
        courseDao.addCourse(course);
    }

    public void updateCourseById(Course course) {
        course.setUpdateTime(new Date());
        courseDao.updateCourseById(course);
    }

    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);
    }

    public List<Course> getCourseList(Course course,Integer pageNum) {
        PageHelper.startPage(pageNum,8);
        return courseDao.getCourseList(course);
    }

    public void deleteCourseByIds(List<Long> ids) {
        courseDao.deleteCourseByIds(ids);
    }

    public List<Course> getCourseByNum(int num) {
        return courseDao.getCourseByNum(num);
    }
}

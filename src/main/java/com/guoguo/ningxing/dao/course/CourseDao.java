package com.guoguo.ningxing.dao.course;

import com.guoguo.ningxing.entity.course.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {

    Course getCourseById(@Param("id") Long id);

    void addCourse(Course course);

    void updateCourseById(Course course);

    void deleteCourseById(@Param("id") Long id);

    List<Course> getCourseList(Course course);

    void deleteCourseByIds(List<Long> ids);

    List<Course> getCourseByNum(int num);
}

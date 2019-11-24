package com.guoguo.ningxing.dao.teacher;

import com.guoguo.ningxing.entity.teacher.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {

    Teacher getTeacherById(@Param("id") Long id);

    void addTeacher(Teacher teacher);

    void updateTeacherById(Teacher teacher);

    void deleteTeacherById(@Param("id") Long id);

    List<Teacher> getTeacherList(Teacher teacher);

    void deleteTeacherByIds(List<Long> ids);

    List<Teacher> getTeacherByNum(int num);
}

package com.guoguo.ningxing.service.teacher;

import com.github.pagehelper.PageHelper;
import com.guoguo.ningxing.dao.teacher.TeacherDao;
import com.guoguo.ningxing.entity.teacher.Teacher;
import com.guoguo.util.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private RequestService requestService;

    public Teacher getTeacherById(Long id) {
        return teacherDao.getTeacherById(id);
    }

    public void addTeacher(Teacher teacher) {
        Date date = new Date();
        teacher.setAddTime(date);
        teacher.setUpdateTime(date);
        teacherDao.addTeacher(teacher);
    }

    public void updateTeacherById(Teacher teacher) {
        teacher.setUpdateTime(new Date());
        teacherDao.updateTeacherById(teacher);
    }

    public void deleteTeacherById(Long id) {
        teacherDao.deleteTeacherById(id);
    }

    public List<Teacher> getTeacherList(Teacher teacher, Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        return teacherDao.getTeacherList(teacher);
    }

    public void deleteTeacherByIds(List<Long> ids) {
        teacherDao.deleteTeacherByIds(ids);
    }

    public List<Teacher> getTeacherByNum(int num) {
        return teacherDao.getTeacherByNum(num);
    }
}

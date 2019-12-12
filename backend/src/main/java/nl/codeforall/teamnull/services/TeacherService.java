package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.dao.jpa.SchoolJpaDao;
import nl.codeforall.teamnull.persistence.dao.jpa.TeacherJpaDao;
import nl.codeforall.teamnull.persistence.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {

    private TeacherJpaDao teacherDao;
    private SchoolJpaDao schoolDao;

    @Autowired
    public void setTeacherDao(TeacherJpaDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setSchoolDao(SchoolJpaDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        return teacherDao.saveOrUpdate(teacher);
    }

    @Transactional
    public void delete(Integer id) {
        teacherDao.delete(id);
    }

    @Transactional
    public List<Teacher> list() {
        return teacherDao.findAll();
    }


}

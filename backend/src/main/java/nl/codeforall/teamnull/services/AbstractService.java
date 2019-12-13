package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.dao.jpa.SchoolJpaDao;
import nl.codeforall.teamnull.persistence.dao.jpa.TeacherJpaDao;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractService {

    protected TeacherJpaDao teacherDao;
    protected SchoolJpaDao schoolDao;

    @Autowired
    public void setTeacherDao(TeacherJpaDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setSchoolDao(SchoolJpaDao schoolDao) {
        this.schoolDao = schoolDao;
    }

}

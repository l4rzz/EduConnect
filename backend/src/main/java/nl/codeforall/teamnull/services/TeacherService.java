package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.dao.jpa.SchoolJpaDao;
import nl.codeforall.teamnull.persistence.dao.jpa.TeacherJpaDao;
import nl.codeforall.teamnull.persistence.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService extends AbstractService implements GenericService<Teacher> {

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.saveOrUpdate(teacher);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        teacherDao.delete(id);
    }

    @Transactional
    @Override
    public List<Teacher> list() {
        return teacherDao.findAll();
    }


}

package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.persistence.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService extends AbstractService implements GenericService<Teacher, School> {

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

    @Transactional
    @Override
    public Teacher get(Integer id) {
        return teacherDao.findById(id);
    }

    @Transactional
    @Override
    public List<School> match(Integer id) {

        Teacher teacher = teacherDao.findById(id);
        List<School> availableSchools = new ArrayList<>();
        for (School school : schoolDao.findAll()) {
            if (teacher.getEndDate().before(school.getEndDate()) || teacher.getStartDate().after(school.getStartDate()) || teacher.getStartDate() == school.getStartDate() || teacher.getEndDate() == school.getEndDate()) {
                availableSchools.add(school);
            }
        }

        return availableSchools;
    }
}

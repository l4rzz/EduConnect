package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.model.School;
import nl.codeforall.teamnull.persistence.model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService extends AbstractService implements GenericService<School, Teacher> {

    @Transactional
    @Override
    public School save(School school) {
        return schoolDao.saveOrUpdate(school);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        schoolDao.delete(id);
    }

    @Transactional
    @Override
    public List<School> list() {
        return schoolDao.findAll();
    }

    @Transactional
    @Override
    public School get(Integer id) {
        return schoolDao.findById(id);
    }

    @Transactional
    @Override
    public List<Teacher> match(Integer id) {

        School school = schoolDao.findById(id);
        List<Teacher> availableTeachers = new ArrayList<>();
        for (Teacher teacher : teacherDao.findAll()) {
            if (school.getEndDate().before(teacher.getEndDate()) || school.getStartDate().after(teacher.getStartDate()) || school.getStartDate() == teacher.getStartDate() || school.getEndDate() == teacher.getEndDate()) {
                availableTeachers.add(teacher);
            }
        }

        return availableTeachers;
    }
}

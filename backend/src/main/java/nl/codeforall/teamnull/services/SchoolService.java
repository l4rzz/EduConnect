package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.model.School;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolService extends AbstractService implements GenericService<School> {

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
}

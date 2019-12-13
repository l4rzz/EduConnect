package nl.codeforall.teamnull.persistence.dao.jpa;

import nl.codeforall.teamnull.persistence.model.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherJpaDao extends GenericJpaDao<Teacher> {

    public TeacherJpaDao() {
        super(Teacher.class);
    }
}

package nl.codeforall.teamnull.persistence.dao.jpa;

import nl.codeforall.teamnull.persistence.model.Teacher;

public class TeacherJpaDao extends GenericJpaDao<Teacher> {

    public TeacherJpaDao(Class<Teacher> modelType) {
        super(modelType);
    }
}

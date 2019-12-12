package nl.codeforall.teamnull.persistence.dao.jpa;

import nl.codeforall.teamnull.persistence.model.School;

public class SchoolJpaDao extends GenericJpaDao<School> {

    public SchoolJpaDao(Class<School> modelType) {
        super(modelType);
    }
}

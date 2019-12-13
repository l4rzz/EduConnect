package nl.codeforall.teamnull.persistence.dao.jpa;

import nl.codeforall.teamnull.persistence.model.School;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolJpaDao extends GenericJpaDao<School> {

    public SchoolJpaDao() {
        super(School.class);
    }
}

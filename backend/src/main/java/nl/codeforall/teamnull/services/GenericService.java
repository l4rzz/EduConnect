package nl.codeforall.teamnull.services;

import nl.codeforall.teamnull.persistence.model.Model;

import java.util.List;

public interface GenericService<T extends Model> {

    T save(T modelObject);

    void delete(Integer id);

    List<T> list();

    T get(Integer id);
}

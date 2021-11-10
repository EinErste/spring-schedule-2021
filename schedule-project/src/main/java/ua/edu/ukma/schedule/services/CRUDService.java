package ua.edu.ukma.schedule.services;

import java.util.Collection;

public interface CRUDService<T> {

    T save(T entity);

    T getById(long id);

    void delete(T entity);

    void delete(long id);

    Collection<T> getAll();

    boolean existsById(Long id);
}

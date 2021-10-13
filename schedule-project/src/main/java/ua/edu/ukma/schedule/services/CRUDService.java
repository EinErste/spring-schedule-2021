package ua.edu.ukma.schedule.services;

public interface CRUDService<T> {

    T save(T entity);

    T getById(long id);

    void delete(T entity);

}

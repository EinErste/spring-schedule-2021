package ua.edu.ukma.schedule.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.services.CRUDService;

import java.util.Objects;

public class AbstractCRUDService<T> implements CRUDService<T> {

    protected JpaRepository<T, Long> repository;

    public AbstractCRUDService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        Objects.requireNonNull(entity, "Entity must be not null");
        return repository.save(entity);
    }

    @Override
    public T getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void delete(T entity) {
        Objects.requireNonNull(entity, "Entity must be not null");
        repository.delete(entity);
    }
}

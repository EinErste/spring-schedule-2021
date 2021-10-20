package ua.edu.ukma.schedule.services.impl;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.ukma.schedule.services.CRUDService;

import java.util.Objects;
@Log4j2
public class AbstractCRUDService<T> implements CRUDService<T> {
    private static final Marker SHOW = MarkerManager.getMarker("SHOW");

    protected JpaRepository<T, Long> repository;

    public AbstractCRUDService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        Objects.requireNonNull(entity, "Entity must be not null");
        log.info(SHOW, "Saving {}",entity.getClass().toString());
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
        log.info(SHOW, "{} was deleted",entity.getClass().toString());
    }
}

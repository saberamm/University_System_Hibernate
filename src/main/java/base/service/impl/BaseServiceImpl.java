package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;
import jakarta.persistence.EntityNotFoundException;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.save(e);
            repository.getEntityManager().getTransaction().commit();
            return e;
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while saving entity: " + ex.getMessage(), ex);
        }
    }


    @Override
    public E update(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.update(e);
            repository.getEntityManager().getTransaction().commit();
            return e;
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while updating entity: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(E e) {
        try {
            repository.getEntityManager().getTransaction().begin();
            repository.delete(e);
            repository.getEntityManager().getTransaction().commit();
        } catch (Exception ex) {
            if (repository.getEntityManager().getTransaction().isActive()) {
                repository.getEntityManager().getTransaction().rollback();
            }
            throw new RuntimeException("Error while deleting entity: " + ex.getMessage(), ex);
        }
    }

    @Override
    public E findById(ID id) {
        E e;
        try {
            e = repository.findById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error while finding entity by ID: " + ex.getMessage(), ex);
        }
        if (e == null) {
            throw new EntityNotFoundException("Entity is not exist");
        } else return e;
    }

    @Override
    public List<E> findAll() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error while fetching entities: " + ex.getMessage(), ex);
        }
    }

    @Override
    public boolean isContainById(ID id) {
        try {
            return repository.isContainById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error while checking if entity exists: " + ex.getMessage(), ex);
        }
    }
}


package br.lablink.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class GenericRepository<T> implements Serializable {

    private Class<T> clazz;

    @Inject
    protected EntityManager entityManager;

    public GenericRepository() {
    }

    public GenericRepository(Class<T> clazz) {
        setClazz(clazz);
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T find(final long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> listAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public T create(final T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = find(entityId);
        delete(entity);
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    public void flush() {
        entityManager.flush();
    }
}

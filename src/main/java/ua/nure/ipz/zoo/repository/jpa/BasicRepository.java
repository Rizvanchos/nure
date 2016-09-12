package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.repository.Repository;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class BasicRepository<T extends DomainEntity> implements Repository<T> {

    private EntityManager entityManager;
    private Class<T> clazz;

    public BasicRepository(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public long count() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(clazz);

        criteriaQuery.select(criteriaBuilder.countDistinct(root));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public T load(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Iterable<T> loadAll() {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.select(criteria.from(clazz));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public void add(T obj) {
        entityManager.persist(obj);
    }

    @Override
    public void delete(T obj) {
        entityManager.remove(obj);
    }

    @Override
    public void commit() {
        entityManager.flush();
    }
}

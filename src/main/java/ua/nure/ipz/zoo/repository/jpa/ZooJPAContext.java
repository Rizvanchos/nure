package ua.nure.ipz.zoo.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ZooJPAContext implements AutoCloseable {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ZooJPAContext(String persistenceUnitName) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @Override
    public void close() throws Exception {
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

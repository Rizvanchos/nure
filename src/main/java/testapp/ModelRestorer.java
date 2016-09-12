package testapp;


import ua.nure.ipz.zoo.repository.Repository;
import ua.nure.ipz.zoo.repository.jpa.RepositoryFactory;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ModelRestorer {

    private EntityManager entityManager;

    public ModelRestorer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ZooModel restore() {
        ZooModel zoo = new ZooModel();

        restoreCollection(RepositoryFactory.makeProductRepository(entityManager), zoo.getProducts());
        restoreCollection(RepositoryFactory.makeTicketRepository(entityManager), zoo.getTickets());
        restoreCollection(RepositoryFactory.makeCartRepository(entityManager), zoo.getCarts());
        restoreCollection(RepositoryFactory.makeAnimalRepository(entityManager), zoo.getAnimals());
        restoreCollection(RepositoryFactory.makeAviaryRepository(entityManager), zoo.getAviaries());
        restoreCollection(RepositoryFactory.makeRationRepository(entityManager), zoo.getRations());
        restoreCollection(RepositoryFactory.makeScheduleRepository(entityManager), zoo.getSchedules());
        restoreCollection(RepositoryFactory.makeAccountRepository(entityManager), zoo.getAccounts());
        restoreCollection(RepositoryFactory.makeOrderRepository(entityManager), zoo.getOrders());
        restoreCollection(RepositoryFactory.makeProvisionRepository(entityManager), zoo.getProvisions());
        restoreCollection(RepositoryFactory.makeProvisionLogRepository(entityManager), zoo.getProvisionLogs());
        restoreCollection(RepositoryFactory.makeOrderLogRepository(entityManager), zoo.getOrderLogs());

        return zoo;
    }

    private <T extends DomainEntity> void restoreCollection(Repository<T> repository, List<T> target) {
        for (T obj : repository.loadAll()) {
            target.add(obj);
        }
    }
}
package testapp;

import ua.nure.ipz.zoo.repository.Repository;
import ua.nure.ipz.zoo.repository.jpa.RepositoryFactory;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ModelSaver {

    private EntityManager entityManager;

    public ModelSaver(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(ZooModel zoo) {

        saveCollection(RepositoryFactory.makeProductRepository(entityManager), zoo.getProducts());
        saveCollection(RepositoryFactory.makeTicketRepository(entityManager), zoo.getTickets());
        saveCollection(RepositoryFactory.makeCartRepository(entityManager), zoo.getCarts());
        saveCollection(RepositoryFactory.makeAnimalRepository(entityManager), zoo.getAnimals());
        saveCollection(RepositoryFactory.makeAviaryRepository(entityManager), zoo.getAviaries());
        saveCollection(RepositoryFactory.makeRationRepository(entityManager), zoo.getRations());
        saveCollection(RepositoryFactory.makeScheduleRepository(entityManager), zoo.getSchedules());
        saveCollection(RepositoryFactory.makeAccountRepository(entityManager), zoo.getAccounts());
        saveCollection(RepositoryFactory.makeOrderRepository(entityManager), zoo.getOrders());
        saveCollection(RepositoryFactory.makeProvisionRepository(entityManager), zoo.getProvisions());
        saveCollection(RepositoryFactory.makeProvisionLogRepository(entityManager), zoo.getProvisionLogs());
        saveCollection(RepositoryFactory.makeOrderLogRepository(entityManager), zoo.getOrderLogs());

    }

    private <TRepository extends Repository<TEntity>, TEntity extends DomainEntity> void saveCollection(TRepository repository, List<TEntity> collection) {
        collection.forEach(repository::add);
    }
}
package ua.nure.ipz.zoo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.ipz.zoo.repository.Repository;
import ua.nure.ipz.zoo.repository.jpa.RepositoryFactory;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ModelSaver {

    @PersistenceContext(unitName = "zooCreate")
    private EntityManager entityManager;
    @Autowired
    private RepositoryFactory repositoryFactory;

    @Transactional
    public void save(ZooModel zoo) {

        saveCollection(repositoryFactory.makeProductRepository(entityManager), zoo.getProducts());
        saveCollection(repositoryFactory.makeTicketRepository(entityManager), zoo.getTickets());
        saveCollection(repositoryFactory.makeCartRepository(entityManager), zoo.getCarts());
        saveCollection(repositoryFactory.makeAnimalRepository(entityManager), zoo.getAnimals());
        saveCollection(repositoryFactory.makeAviaryRepository(entityManager), zoo.getAviaries());
        saveCollection(repositoryFactory.makeRationRepository(entityManager), zoo.getRations());
        saveCollection(repositoryFactory.makeScheduleRepository(entityManager), zoo.getSchedules());
        saveCollection(repositoryFactory.makeAccountRepository(entityManager), zoo.getAccounts());
        saveCollection(repositoryFactory.makeOrderRepository(entityManager), zoo.getOrders());
        saveCollection(repositoryFactory.makeProvisionRepository(entityManager), zoo.getProvisions());
        saveCollection(repositoryFactory.makeProvisionLogRepository(entityManager), zoo.getProvisionLogs());
        saveCollection(repositoryFactory.makeOrderLogRepository(entityManager), zoo.getOrderLogs());

    }

    private <TRepository extends Repository<TEntity>, TEntity extends DomainEntity> void saveCollection(TRepository repository, List<TEntity> collection) {
        collection.forEach(repository::add);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setRepositoryFactory(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }
}
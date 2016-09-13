package ua.nure.ipz.zoo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.nure.ipz.zoo.repository.Repository;
import ua.nure.ipz.zoo.repository.jpa.RepositoryFactory;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Component
public class ModelRestorer {

    @PersistenceContext(unitName = "zooRead", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    @Autowired
    private RepositoryFactory repositoryFactory;

    public ZooModel restore() {
        ZooModel zoo = new ZooModel();

        restoreCollection(repositoryFactory.makeProductRepository(entityManager), zoo.getProducts());
        restoreCollection(repositoryFactory.makeTicketRepository(entityManager), zoo.getTickets());
        restoreCollection(repositoryFactory.makeCartRepository(entityManager), zoo.getCarts());
        restoreCollection(repositoryFactory.makeAnimalRepository(entityManager), zoo.getAnimals());
        restoreCollection(repositoryFactory.makeAviaryRepository(entityManager), zoo.getAviaries());
        restoreCollection(repositoryFactory.makeRationRepository(entityManager), zoo.getRations());
        restoreCollection(repositoryFactory.makeScheduleRepository(entityManager), zoo.getSchedules());
        restoreCollection(repositoryFactory.makeAccountRepository(entityManager), zoo.getAccounts());
        restoreCollection(repositoryFactory.makeOrderRepository(entityManager), zoo.getOrders());
        restoreCollection(repositoryFactory.makeProvisionRepository(entityManager), zoo.getProvisions());
        restoreCollection(repositoryFactory.makeProvisionLogRepository(entityManager), zoo.getProvisionLogs());
        restoreCollection(repositoryFactory.makeOrderLogRepository(entityManager), zoo.getOrderLogs());

        return zoo;
    }

    private <T extends DomainEntity> void restoreCollection(Repository<T> repository, List<T> target) {
        for (T obj : repository.loadAll()) {
            target.add(obj);
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setRepositoryFactory(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }
}
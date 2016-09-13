package ua.nure.ipz.zoo.repository.jpa;

import org.springframework.stereotype.Component;
import ua.nure.ipz.zoo.repository.AccountRepository;
import ua.nure.ipz.zoo.repository.AnimalRepository;
import ua.nure.ipz.zoo.repository.AviaryRepository;
import ua.nure.ipz.zoo.repository.CartRepository;
import ua.nure.ipz.zoo.repository.OrderLogRepository;
import ua.nure.ipz.zoo.repository.OrderRepository;
import ua.nure.ipz.zoo.repository.ProductRepository;
import ua.nure.ipz.zoo.repository.ProvisionLogRepository;
import ua.nure.ipz.zoo.repository.ProvisionRepository;
import ua.nure.ipz.zoo.repository.RationRepository;
import ua.nure.ipz.zoo.repository.ScheduleRepository;
import ua.nure.ipz.zoo.repository.TicketRepository;

import javax.persistence.EntityManager;

@Component
public class RepositoryFactory {

    public AccountRepository makeAccountRepository(EntityManager entityManager) {
        return new DefaultAccountRepository(entityManager);
    }

    public AnimalRepository makeAnimalRepository(EntityManager entityManager) {
        return new DefaultAnimalRepository(entityManager);
    }

    public AviaryRepository makeAviaryRepository(EntityManager entityManager) {
        return new DefaultAviaryRepository(entityManager);
    }

    public CartRepository makeCartRepository(EntityManager entityManager) {
        return new DefaultCartRepository(entityManager);
    }

    public OrderLogRepository makeOrderLogRepository(EntityManager entityManager) {
        return new DefaultOrderLogRepository(entityManager);
    }

    public OrderRepository makeOrderRepository(EntityManager entityManager) {
        return new DefaultOrderRepository(entityManager);
    }

    public ProductRepository makeProductRepository(EntityManager entityManager) {
        return new DefaultProductRepository(entityManager);
    }

    public ProvisionRepository makeProvisionRepository(EntityManager entityManager) {
        return new DefaultProvisionRepository(entityManager);
    }

    public ProvisionLogRepository makeProvisionLogRepository(EntityManager entityManager) {
        return new DefaultProvisionLogRepository(entityManager);
    }

    public RationRepository makeRationRepository(EntityManager entityManager) {
        return new DefaultRationRepository(entityManager);
    }

    public ScheduleRepository makeScheduleRepository(EntityManager entityManager) {
        return new DefaultScheduleRepository(entityManager);
    }

    public TicketRepository makeTicketRepository(EntityManager entityManager) {
        return new DefaultTicketRepository(entityManager);
    }
}
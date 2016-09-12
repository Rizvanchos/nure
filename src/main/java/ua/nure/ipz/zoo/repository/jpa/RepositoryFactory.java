package ua.nure.ipz.zoo.repository.jpa;

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

public class RepositoryFactory {

    public static AccountRepository makeAccountRepository(EntityManager entityManager) {
        return new DefaultAccountRepository(entityManager);
    }

    public static AnimalRepository makeAnimalRepository(EntityManager entityManager) {
        return new DefaultAnimalRepository(entityManager);
    }

    public static AviaryRepository makeAviaryRepository(EntityManager entityManager) {
        return new DefaultAviaryRepository(entityManager);
    }

    public static CartRepository makeCartRepository(EntityManager entityManager) {
        return new DefaultCartRepository(entityManager);
    }

    public static OrderLogRepository makeOrderLogRepository(EntityManager entityManager) {
        return new DefaultOrderLogRepository(entityManager);
    }

    public static OrderRepository makeOrderRepository(EntityManager entityManager) {
        return new DefaultOrderRepository(entityManager);
    }

    public static ProductRepository makeProductRepository(EntityManager entityManager) {
        return new DefaultProductRepository(entityManager);
    }

    public static ProvisionRepository makeProvisionRepository(EntityManager entityManager) {
        return new DefaultProvisionRepository(entityManager);
    }

    public static ProvisionLogRepository makeProvisionLogRepository(EntityManager entityManager) {
        return new DefaultProvisionLogRepository(entityManager);
    }

    public static RationRepository makeRationRepository(EntityManager entityManager) {
        return new DefaultRationRepository(entityManager);
    }

    public static ScheduleRepository makeScheduleRepository(EntityManager entityManager) {
        return new DefaultScheduleRepository(entityManager);
    }

    public static TicketRepository makeTicketRepository(EntityManager entityManager) {
        return new DefaultTicketRepository(entityManager);
    }
}

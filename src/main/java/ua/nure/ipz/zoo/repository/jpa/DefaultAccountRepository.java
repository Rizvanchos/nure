package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.user.Account;
import ua.nure.ipz.zoo.repository.AccountRepository;

import javax.persistence.EntityManager;

public class DefaultAccountRepository extends BasicRepository<Account> implements AccountRepository {
    public DefaultAccountRepository(EntityManager entityManager) {
        super(entityManager, Account.class);
    }
}

package ua.nure.ipz.zoo.repository;

import ua.nure.ipz.zoo.util.DomainEntity;

public interface Repository<T extends DomainEntity> {
    long count();

    T load(int id);

    Iterable<T> loadAll();

    void add(T t);

    void delete(T t);

    void commit();
}

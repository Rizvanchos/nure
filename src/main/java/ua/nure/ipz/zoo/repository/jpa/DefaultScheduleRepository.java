package ua.nure.ipz.zoo.repository.jpa;

import ua.nure.ipz.zoo.entity.Schedule;
import ua.nure.ipz.zoo.repository.ScheduleRepository;

import javax.persistence.EntityManager;

public class DefaultScheduleRepository extends BasicRepository<Schedule> implements ScheduleRepository {
    public DefaultScheduleRepository(EntityManager entityManager) {
        super(entityManager, Schedule.class);
    }
}

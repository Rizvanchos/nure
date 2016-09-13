package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Schedule extends DomainEntity {

    @ElementCollection
    private Map<Aviary, String> schedules = new HashMap<>();

    public String generateSchedule() {
        StringBuilder sb = new StringBuilder();
        schedules.entrySet().forEach(e -> sb.append("\nAviary = " + e.getKey() + "\nTime: " + e.getValue() + "\n"));
        return sb.toString();
    }

    public Map<Aviary, String> getSchedules() {
        return schedules;
    }

    public void setSchedules(Map<Aviary, String> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "ID = " + getDomainId() + "\n" + generateSchedule();
    }
}

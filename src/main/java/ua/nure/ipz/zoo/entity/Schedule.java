package ua.nure.ipz.zoo.entity;

import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.ElementCollection;
import java.util.HashMap;
import java.util.Map;

//@Entity
public class Schedule extends DomainEntity {

    @ElementCollection
    private Map<Aviary, String> schedule = new HashMap<>();

    public String generateSchedule() {
        StringBuilder sb = new StringBuilder();
        schedule.entrySet().forEach(e -> sb.append("\nAviary = " + e.getKey() + "\nTime: " + e.getValue() + "\n"));
        return sb.toString();
    }

    public Map<Aviary, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Aviary, String> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ID = " + getDomainId() + "\n" + generateSchedule();
    }
}

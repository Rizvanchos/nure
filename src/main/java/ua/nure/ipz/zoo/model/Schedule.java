package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.util.Entity;
import ua.nure.ipz.zoo.util.Regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Schedule extends Entity {

    private Map<Aviary, String> schedule = new HashMap<>();

    public boolean add(Aviary aviary, String time) {
        if (aviary == null || !Pattern.matches(Regex.TIME_FORMAT, time)) {
            throw new IllegalArgumentException("aviary");
        }
        return null != schedule.put(aviary, time);
    }

    public String generateSchedule() {
        return currentSchedule();
    }

    private String currentSchedule() {
        StringBuilder sb = new StringBuilder();
        schedule.entrySet().forEach(e -> sb.append("\nAviary = " + e.getKey() + "\nTime: " + e.getValue() + "\n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ID = " + getDomainId() + "\n" + currentSchedule();
    }
}

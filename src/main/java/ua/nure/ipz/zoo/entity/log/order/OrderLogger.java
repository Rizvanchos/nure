package ua.nure.ipz.zoo.entity.log.order;

import ua.nure.ipz.zoo.entity.order.Order;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class OrderLogger extends OrderLog {
    @Lob
    private String log;

    @Override
    public void log(Order target) {
        log += target + "\n";
    }

    @Override
    public String getLog() {
        return log;
    }

    @Override
    public String toString() {
        return getLog();
    }
}

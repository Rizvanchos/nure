package ua.nure.ipz.zoo.entity.log.order;

import ua.nure.ipz.zoo.entity.order.Order;

//@Entity
public class OrderLogger extends OrderLog {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void log(Order target) {
        stringBuilder.append(target + "\n");
    }

    @Override
    public String getLog() {
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getLog();
    }
}

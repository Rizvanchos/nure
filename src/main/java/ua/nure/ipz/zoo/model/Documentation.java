package ua.nure.ipz.zoo.model;

public class Documentation {

    private StringBuilder provisionLog = new StringBuilder();
    private StringBuilder orderLog = new StringBuilder();

    public void logProvision(Provision provision) {
        provisionLog.append(provision + "\n");
    }

    public void logOrder(Order order) {
        orderLog.append(order + "\n");
    }

    public String viewProvisionLog() {
        return provisionLog.toString();
    }

    public String viewOrderLog() {
        return orderLog.toString();
    }

    public String toString() {
        return viewProvisionLog() + "\n" + viewOrderLog();
    }
}

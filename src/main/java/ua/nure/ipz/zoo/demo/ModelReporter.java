package ua.nure.ipz.zoo.demo;

import java.io.PrintStream;
import java.util.List;

public class ModelReporter {

    private PrintStream output;

    public ModelReporter(PrintStream output) {
        this.output = output;
    }

    public void generateReport(ZooModel model) {
        reportCollection("Accounts", model.getAccounts());
        reportCollection("Animals", model.getAnimals());
        reportCollection("Aviaries", model.getAviaries());
        reportCollection("Carts", model.getCarts());
        reportCollection("Orders", model.getOrders());
        reportCollection("Rations", model.getRations());
        reportCollection("Provisions", model.getProvisions());
        reportCollection("Schedules", model.getSchedules());
        reportCollection("Tickets", model.getTickets());
        reportCollection("Order logs", model.getOrderLogs());
        reportCollection("Provision logs", model.getProvisionLogs());
    }

    private <T> void reportCollection(String title, List<T> items) {
        output.format("==== %s ====\n\n", title);
        for (T item : items) {
            output.print(item);
            output.print("\n\n");
        }
        output.println();
    }

}

package testapp;

import java.io.PrintStream;
import java.util.List;

public class ModelReporter {

     public ModelReporter(PrintStream output) {
        this.output = output;
    }

	public void generateReport(ZooModel model) {
		reportCollection("Accounts", model.getAccounts());
		reportCollection("Animals", model.getAnimals());
		reportCollection("Aviaries", model.getAviaries());
		reportCollection("Carts", model.getCarts());
		reportCollection("Orders", model.getOrders());
		reportCollection("Rations", model.getRatitons());
		reportCollection("Provisions", model.getProvisions());
		reportCollection("Schedules", model.getSchedules());
		reportCollection("Tickets", model.getTickets());
		reportCollection("Documentations", model.getDocumentations());
	}

	private <T> void reportCollection(String title, List<T> items) {
		output.format("==== %s ====\n\n", title);

		for (T item : items) {
			output.print(item);
			output.print("\n\n");
		}

		output.println();
	}

	private PrintStream output;

}

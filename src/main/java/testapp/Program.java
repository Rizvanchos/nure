package testapp;

public class Program {

    public static void main(String[] args) {
        ZooModel zoo = TestModelGenerator.generateData();
        ModelReporter reporter = new ModelReporter(System.out);

        reporter.generateReport(zoo);
    }

}

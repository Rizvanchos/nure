package ua.nure.ipz.zoo.demo;

public class Program {

    public static void main(String[] args) {
        ZooModel zoo = ZooModelGenerator.generateData();
        ModelReporter reporter = new ModelReporter(System.out);

        reporter.generateReport(zoo);
    }

}

package testapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Demo {

    public static void main(String[] args) {
        try {
            ZooModel model1 = TestModelGenerator.generateData();

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            ModelSaver saver = new ModelSaver(entityManager);
            saver.save(model1);

            entityManager = entityManagerFactory.createEntityManager();

            ModelRestorer restorer = new ModelRestorer(entityManager);
            ZooModel model2 = restorer.restore();

            compareModels(model1, model2);
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    private static void compareModels(ZooModel model1, ZooModel model2) {
        ByteArrayOutputStream writer1 = new ByteArrayOutputStream();
        ModelReporter reportGenerator1 = new ModelReporter(new PrintStream(writer1));
        reportGenerator1.generateReport(model1);

        ByteArrayOutputStream writer2 = new ByteArrayOutputStream();
        ModelReporter reportGenerator2 = new ModelReporter(new PrintStream(writer2));
        reportGenerator2.generateReport(model2);

        String report1Content = writer1.toString();
        String report2Content = writer2.toString();

        System.out.println(report1Content);

        System.out.println("================================================================");
        System.out.println();

        System.out.println(report2Content);

        System.out.println("================================================================");
        System.out.println();

        System.out.println(report1Content.equals(report2Content) ? "PASSED: Models match" : "FAILED: Models mismatch");
    }
}

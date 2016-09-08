package testapp;

import ua.nure.ipz.zoo.model.Product;
import ua.nure.ipz.zoo.model.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        ZooModel zoo = TestModelGenerator.generateData();
        List<Product> products = zoo.getProducts();
        List<Ticket> tickets = zoo.getTickets();

        EntityManager entityManager = Persistence.createEntityManagerFactory("entityManager").createEntityManager();
        entityManager.getTransaction().begin();

        products.forEach(entityManager::persist);
        tickets.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
    }

}

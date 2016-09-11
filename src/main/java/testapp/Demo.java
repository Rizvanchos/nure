package testapp;

import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.entity.user.CartEntry;
import ua.nure.ipz.zoo.entity.Product;
import ua.nure.ipz.zoo.entity.ticket.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ZooModel zoo = TestModelGenerator.generateData();

        List<Product> products = zoo.getProducts();
        List<Ticket> tickets = zoo.getTickets();
        List<Cart> carts = zoo.getCarts();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //products.forEach(entityManager::persist);
        tickets.forEach(entityManager::persist);
        carts.forEach(entityManager::persist);

        entityManager.getTransaction().commit();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        System.out.println(entityManager.find(Cart.class, 1).getCartEntries());
        System.out.println(entityManager.find(CartEntry.class, 1).getCart());

        entityManager.getTransaction().commit();
    }

}

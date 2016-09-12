package testapp;

import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.entity.Aviary;
import ua.nure.ipz.zoo.entity.Schedule;
import ua.nure.ipz.zoo.entity.food.Product;
import ua.nure.ipz.zoo.entity.food.Provision;
import ua.nure.ipz.zoo.entity.food.Ration;
import ua.nure.ipz.zoo.entity.food.RationEntry;
import ua.nure.ipz.zoo.entity.log.provision.ProvisionLog;
import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.entity.user.CartEntry;

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
        List<Aviary> aviaries = zoo.getAviaries();
        List<Ration> rations = zoo.getRations();
        List<Schedule> schedules = zoo.getSchedules();
        List<Provision> provisions = zoo.getProvisions();
        List<ProvisionLog> provisionLogs = zoo.getProvisionLogs();
        List<Order> orders = zoo.getOrders();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        products.forEach(entityManager::persist);
        tickets.forEach(entityManager::persist);
        carts.forEach(entityManager::persist);
        aviaries.forEach(entityManager::persist);
        rations.forEach(entityManager::persist);
        schedules.forEach(entityManager::persist);
        provisions.forEach(entityManager::persist);
        orders.forEach(entityManager::persist);

        entityManager.getTransaction().commit();

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Cart cart = entityManager.find(Cart.class, 1);
        CartEntry cartEntry = entityManager.find(CartEntry.class, 1);

        System.out.println(cartEntry.getTicket().equals(tickets.get(0)));
        System.out.println(cart.equals(cartEntry.getCart()) && cart.getCartEntries().get(0).equals(cartEntry));

        Aviary aviary = entityManager.find(Aviary.class, 1);
        Animal animal = entityManager.find(Animal.class, 1);

        System.out.println(aviary.equals(animal.getAviary()) && aviary.getAnimals().contains(animal));

        Ration ration = entityManager.find(Ration.class, 1);
        RationEntry rationEntry = entityManager.find(RationEntry.class, 1);

        System.out.println(ration.getRationEntries().get(0).getProduct().equals(rationEntry.getProduct()));
        System.out.println(ration.equals(rationEntry.getRation()) && ration.getRationEntries().get(0).equals(rationEntry));

        Schedule schedule = entityManager.find(Schedule.class, 1);
        Provision provision = entityManager.find(Provision.class, 1);

        System.out.println(schedule.getSchedules().equals(schedules.get(0).getSchedules()));
        System.out.println(provision.getLogger().equals(provisionLogs.get(0)) && (provision.getRations().size() == rations.size()));

        entityManager.getTransaction().commit();
    }

}

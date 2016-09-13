package ua.nure.ipz.zoo.demo;

import ua.nure.ipz.zoo.entity.Animal;
import ua.nure.ipz.zoo.entity.Aviary;
import ua.nure.ipz.zoo.entity.Schedule;
import ua.nure.ipz.zoo.entity.enums.TicketType;
import ua.nure.ipz.zoo.entity.food.Product;
import ua.nure.ipz.zoo.entity.food.Provision;
import ua.nure.ipz.zoo.entity.food.Ration;
import ua.nure.ipz.zoo.entity.log.order.OrderLogger;
import ua.nure.ipz.zoo.entity.log.provision.ProvisionLogger;
import ua.nure.ipz.zoo.entity.order.Contact;
import ua.nure.ipz.zoo.entity.order.Order;
import ua.nure.ipz.zoo.entity.ticket.Ticket;
import ua.nure.ipz.zoo.entity.ticket.TicketDiscount;
import ua.nure.ipz.zoo.entity.ticket.TicketSeller;
import ua.nure.ipz.zoo.entity.user.Cart;

public class ZooModelGenerator {

    public static ZooModel generateData() {
        ZooModel zoo = new ZooModel();

        generateAnimals(zoo);
        generateAviaries(zoo);
        generateSchedules(zoo);
        generateTickets(zoo);
        generateCarts(zoo);
        generateLogs(zoo);
        generateDiscounts(zoo);
        generateOrders(zoo);
        generateAccounts(zoo);
        generateProducts(zoo);
        generateRations(zoo);
        generateProvisions(zoo);

        return zoo;
    }

    private static void generateAnimals(ZooModel zoo) {
        zoo.getAnimals().add(new Animal("Alex", "lion"));
        zoo.getAnimals().add(new Animal("Cowboy", "pantera"));
        zoo.getAnimals().add(new Animal("Crocs", "croc"));
    }

    private static void generateAviaries(ZooModel zoo) {
        Aviary first = new Aviary(20, 5);
        first.getAnimals().add(zoo.getAnimals().get(0));
        first.getAnimals().add(zoo.getAnimals().get(1));

        Aviary second = new Aviary(13, 7);
        second.getAnimals().add(zoo.getAnimals().get(2));

        zoo.getAnimals().get(0).setAviary(first);
        zoo.getAnimals().get(1).setAviary(first);
        zoo.getAnimals().get(2).setAviary(second);

        zoo.getAviaries().add(first);
        zoo.getAviaries().add(second);
    }

    private static void generateSchedules(ZooModel zoo) {
        Schedule schedule = new Schedule();
        schedule.getSchedules().put(zoo.getAviaries().get(0), "10:30-11:30");
        schedule.getSchedules().put(zoo.getAviaries().get(1), "11:30-12:30");

        zoo.getSchedules().add(schedule);
    }

    private static void generateTickets(ZooModel zoo) {
        zoo.getTickets().add(new Ticket(TicketType.CHILD));
        zoo.getTickets().add(new Ticket(TicketType.SCHOOL));
        zoo.getTickets().add(new Ticket(TicketType.STUDENT));
        zoo.getTickets().add(new Ticket(TicketType.STANDARD));
    }

    private static void generateCarts(ZooModel zoo) {
        Cart cart = new Cart();
        cart.getOrderedTickets().put(zoo.getTickets().get(0), 10);
        cart.getOrderedTickets().put(zoo.getTickets().get(1), 5);
        cart.getOrderedTickets().put(zoo.getTickets().get(2), 3);
        cart.getOrderedTickets().put(zoo.getTickets().get(3), 1);

        zoo.getCarts().add(cart);
    }

    private static void generateLogs(ZooModel zoo) {
        zoo.getOrderLogs().add(new OrderLogger());
        zoo.getProvisionLogs().add(new ProvisionLogger());
    }

    private static void generateDiscounts(ZooModel zoo) {
        zoo.getDiscounts().add(new TicketDiscount());
    }

    private static void generateOrders(ZooModel zoo) {
        Order order = new Order(zoo.getCarts().get(0), new Contact("abcde@mail.ru"));
        order.setLogger(zoo.getOrderLogs().get(0));
        order.setDiscount(zoo.getDiscounts().get(0));

        zoo.getOrders().add(order);
        order.process();
    }

    private static void generateAccounts(ZooModel zoo) {
        TicketSeller john = new TicketSeller("Lavretiy", "lavretiy@mail.ru", "abcde");
        john.getOrders().add(zoo.getOrders().get(0));

        zoo.getOrders().get(0).setAccount(john);
        zoo.getAccounts().add(john);
    }

    private static void generateProducts(ZooModel zoo) {
        zoo.getProducts().add(new Product("apple", 5.3f));
        zoo.getProducts().add(new Product("orange", 7.1f));
        zoo.getProducts().add(new Product("banana", 2.0f));
    }

    private static void generateRations(ZooModel zoo) {
        Ration first = new Ration(zoo.getAnimals().get(0));
        first.getRationEntries().put(zoo.getProducts().get(0), 5f);

        Ration second = new Ration(zoo.getAnimals().get(1));
        second.getRationEntries().put(zoo.getProducts().get(1), 1f);
        second.getRationEntries().put(zoo.getProducts().get(2), 3f);

        Ration third = new Ration(zoo.getAnimals().get(2));
        third.getRationEntries().put(zoo.getProducts().get(0), 10f);
        third.getRationEntries().put(zoo.getProducts().get(2), 4.7f);

        zoo.getRations().add(first);
        zoo.getRations().add(second);
        zoo.getRations().add(third);
    }

    private static void generateProvisions(ZooModel zoo) {
        Provision provision = new Provision();
        provision.setLogger(zoo.getProvisionLogs().get(0));
        provision.getRations().add(zoo.getRations().get(0));
        provision.getRations().add(zoo.getRations().get(1));
        provision.getRations().add(zoo.getRations().get(2));

        provision.productsToBuy();

        zoo.getProvisions().add(provision);
    }

}

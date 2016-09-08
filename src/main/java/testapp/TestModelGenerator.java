package testapp;

import ua.nure.ipz.zoo.model.*;
import ua.nure.ipz.zoo.model.enums.TicketType;

public class TestModelGenerator {

    public static ZooModel generateData() {
        ZooModel m = new ZooModel();

        generateAnimals(m);
        generateAviaries(m);
        generateSchedules(m);
        generateTickets(m);
        generateCarts(m);
        generateLogs(m);
        generateOrders(m);
        generateAccounts(m);
        generateProducts(m);
        generateRations(m);
        generateProvisions(m);

        return m;
    }

    private static void generateAnimals(ZooModel m) {
        m.getAnimals().add(new Animal("Alex", "lion"));
        m.getAnimals().add(new Animal("Cowboy", "pantera"));
        m.getAnimals().add(new Animal("Crocs", "croc"));
    }

    private static void generateAviaries(ZooModel m) {
        Aviary first = new Aviary(20, 5);
        first.addAnimal(m.getAnimals().get(0));
        first.addAnimal(m.getAnimals().get(1));

        Aviary second = new Aviary(13, 7);
        second.addAnimal(m.getAnimals().get(2));

        m.getAviaries().add(first);
        m.getAviaries().add(second);
    }

    private static void generateSchedules(ZooModel m) {
        Schedule schedule = new Schedule();
        schedule.add(m.getAviaries().get(0), "10:30-11:30");
        schedule.add(m.getAviaries().get(1), "11:30-12:30");

        m.getSchedules().add(schedule);
    }

    private static void generateTickets(ZooModel m) {
        m.getTickets().add(new Ticket(TicketType.CHILD));
        m.getTickets().add(new Ticket(TicketType.SCHOOL));
        m.getTickets().add(new Ticket(TicketType.STUDENT));
        m.getTickets().add(new Ticket(TicketType.STANDARD));
    }

    private static void generateCarts(ZooModel m) {
        Cart cart = new Cart();
        cart.add(m.getTickets().get(0), 10);
        cart.add(m.getTickets().get(1), 5);
        cart.add(m.getTickets().get(2), 3);
        cart.add(m.getTickets().get(3), 1);

        m.getCarts().add(cart);
    }

    private static void generateLogs(ZooModel m) {
        m.getDocumentations().add(new Documentation());
    }

    private static void generateOrders(ZooModel m) {
        Order order = new Order(m.getCarts().get(0), new Contact("abcde@mail.ru"));
        order.setDocumentation(m.getDocumentations().get(0));

        m.getOrders().add(order);
        order.process();
    }

    private static void generateAccounts(ZooModel m) {
        TicketSaller wasya = new TicketSaller("Lavretiy", "lavretiy@mail.ru", "abcde");

        wasya.getOrders().add(m.getOrders().get(0));
        m.getAccounts().add(wasya);
    }

    private static void generateProducts(ZooModel m) {
        m.getProducts().add(new Product("apple", 5.3f));
        m.getProducts().add(new Product("orange", 7.1f));
        m.getProducts().add(new Product("banana", 2.0f));
    }

    private static void generateRations(ZooModel m) {
        Ration first = new Ration(m.getAnimals().get(0));
        first.addProduct(m.getProducts().get(0), 5);

        Ration second = new Ration(m.getAnimals().get(1));
        second.addProduct(m.getProducts().get(1), 1);
        second.addProduct(m.getProducts().get(2), 3);

        Ration third = new Ration(m.getAnimals().get(2));
        third.addProduct(m.getProducts().get(0), 10);
        third.addProduct(m.getProducts().get(2), 4.7f);

        m.getRations().add(first);
        m.getRations().add(second);
        m.getRations().add(third);
    }

    private static void generateProvisions(ZooModel m) {
        Provision provision = new Provision();
        provision.setDocumentation(m.getDocumentations().get(0));
        provision.add(m.getRations().get(0));
        provision.add(m.getRations().get(1));
        provision.add(m.getRations().get(2));

        provision.productsToBuy();

        m.getProvisions().add(provision);
    }

}

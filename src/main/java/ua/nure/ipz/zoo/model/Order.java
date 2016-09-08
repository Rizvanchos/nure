package ua.nure.ipz.zoo.model;

import ua.nure.ipz.zoo.model.enums.OrderStatus;
import ua.nure.ipz.zoo.util.Entity;

public class Order extends Entity {

    private Cart cart;
    private Contact contact;
    private float basicPrice;
    private OrderStatus status = OrderStatus.ACCEPTED;
    private Discount discount = new Discount();
    private Documentation logger = new Documentation();

    public Order(Cart cart, Contact contact) {
        this.cart = cart.checkout();
        this.basicPrice = cart.totalPrice();
        this.contact = contact;
    }

    public Cart getCart() {
        return cart;
    }

    public Contact getContact() {
        return contact;
    }

    public float getBasicPrice() {
        return basicPrice;
    }

    public float getTotalPrice() {
        return discount.getDiscountedPrice(cart);
    }

    public Discount getDiscount() {
        return discount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setDiscount(Discount dictount) {
        this.discount = dictount;
    }

    public void setDocumentation(Documentation logger) {
        this.logger = logger;
    }

    public void process() {
        if (status != OrderStatus.ACCEPTED) {
            throw new IllegalStateException("Order must be accepted first!");
        }
        status = OrderStatus.PROCESSING;
        logger.logOrder(this);
    }

    public void finish() {
        if (status != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Order can be finished only if it was processing!");
        }
        status = OrderStatus.FINISHED;
        logger.logOrder(this);
    }

    public void cancel() {
        status = OrderStatus.CANCELLED;
        logger.logOrder(this);
    }

    @Override
    public String toString() {
        return String.format("Cart = %s\nBasic Price = %s\nDiscounted Price = %s\n" + "Contact = %s\nStatus = %s",
                getCart(), getBasicPrice(), getTotalPrice(), getContact(), getStatus());
    }
}

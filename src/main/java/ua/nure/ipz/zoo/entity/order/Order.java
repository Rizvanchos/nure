package ua.nure.ipz.zoo.entity.order;

import ua.nure.ipz.zoo.entity.ticket.Discount;
import ua.nure.ipz.zoo.entity.enums.OrderStatus;
import ua.nure.ipz.zoo.entity.log.order.OrderLog;
import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.Embedded;

//@Entity
public class Order extends DomainEntity {

    private Cart cart;
    private Contact contact;
    private float basicPrice;
    private OrderLog logger;
    private OrderStatus status;

    @Embedded
    private Discount discount;

    public Order() {
    }

    public Order(Cart cart, Contact contact) {
        this.cart = cart.checkout();
        this.basicPrice = cart.totalPrice();
        this.contact = contact;
        this.status = OrderStatus.ACCEPTED;
    }

    public void process() {
        if (status != OrderStatus.ACCEPTED) {
            throw new IllegalStateException("Order must be accepted first!");
        }
        status = OrderStatus.PROCESSING;
        logger.log(this);
    }

    public void finish() {
        if (status != OrderStatus.PROCESSING) {
            throw new IllegalStateException("Order can be finished only if it was processing!");
        }
        status = OrderStatus.FINISHED;
        logger.log(this);
    }

    public void cancel() {
        status = OrderStatus.CANCELLED;
        logger.log(this);
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
        if (discount != null) {
            return discount.discountPrice(cart);
        }
        return basicPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderLog getLogger() {
        return logger;
    }

    public void setLogger(OrderLog logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        return String.format("Cart = %s\nBasic Price = %s\nDiscounted Price = %s\n" + "Contact = %s\nStatus = %s",
                getCart(), getBasicPrice(), getTotalPrice(), getContact(), getStatus());
    }
}

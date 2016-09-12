package ua.nure.ipz.zoo.entity.order;

import ua.nure.ipz.zoo.entity.enums.OrderStatus;
import ua.nure.ipz.zoo.entity.log.order.OrderLog;
import ua.nure.ipz.zoo.entity.log.order.OrderLogger;
import ua.nure.ipz.zoo.entity.ticket.Discount;
import ua.nure.ipz.zoo.entity.ticket.TicketSaller;
import ua.nure.ipz.zoo.entity.user.Account;
import ua.nure.ipz.zoo.entity.user.Cart;
import ua.nure.ipz.zoo.util.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order extends DomainEntity {

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = TicketSaller.class)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(cascade = CascadeType.PERSIST, targetEntity = OrderLogger.class)
    private OrderLog logger;

    @Enumerated
    private OrderStatus status;

    @Embedded
    private Discount discount;
    @Embedded
    private Contact contact;

    @OneToOne
    private Cart cart;

    private float basicPrice;

    public Order() {
    }

    public Order(Cart cart, Contact contact) {
        this.cart = cart.checkout();
        this.basicPrice = cart.totalPrice();
        this.contact = contact;
        this.status = OrderStatus.ACCEPTED;
    }

    public float getTotalPrice() {
        return discount != null ? discount.discountPrice(cart) : basicPrice;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        return String.format("%s\nCart = %s\nBasic Price = %s\nDiscounted Price = %s\n" + "Contact = %s\nStatus = %s",
                super.toString(), cart, basicPrice, getTotalPrice(), contact, status);
    }
}

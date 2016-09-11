package ua.nure.ipz.zoo.entity.order;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    private String email;

    public Contact() {
    }

    public Contact(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email = " + getEmail();
    }
}

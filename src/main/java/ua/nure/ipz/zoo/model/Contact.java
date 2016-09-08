package ua.nure.ipz.zoo.model;

public class Contact {

    private String email;

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

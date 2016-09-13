package ua.nure.ipz.zoo.entity.user;

import ua.nure.ipz.zoo.util.DomainEntity;
import ua.nure.ipz.zoo.util.Regex;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.regex.Pattern;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends DomainEntity {

    private String name;
    private String email;
    private String password;

    public Account() {
    }

    public Account(String name, String email, String password) {
        setName(name);
        setPassword(password);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        checkInput(name);
        this.name = name;
    }

    public void setPassword(String password) {
        checkInput(password);
        this.password = password;
    }

    public void setEmail(String email) {
        checkInput(email);
        if (!Pattern.matches(Regex.EMAIL_FORMAT, email)) {
            throw new IllegalArgumentException("Invalid mail format: " + email);
        }
        this.email = email;
    }

    private void checkInput(String input) {
        if (input.isEmpty() || (input == null)) {
            throw new IllegalArgumentException("Invalid input : " + input);
        }
    }

    @Override
    public String toString() {
        return String.format("ID = %s\nName = %s\nEmail = %s\nPassword = %s", getDomainId(), name, email, password);
    }
}

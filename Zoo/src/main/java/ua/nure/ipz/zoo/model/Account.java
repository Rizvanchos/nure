package ua.nure.ipz.zoo.model;

import java.util.regex.Pattern;

import ua.nure.ipz.zoo.util.Entity;
import ua.nure.ipz.zoo.util.Regex;

public class Account extends Entity {

	private String name;
	private String email;
	private String password;

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

		if (!Pattern.matches(Regex.MAIL_FORMAT, email)) {
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
		return String.format("ID = %s\nName = %s\nEmail = %s\nPassword = %s", getDomainId(), getName(), getEmail(),
				getPassword());
	}
}

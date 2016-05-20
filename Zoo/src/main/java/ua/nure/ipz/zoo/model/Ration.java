package ua.nure.ipz.zoo.model;

import java.util.HashMap;
import java.util.Map;

import ua.nure.ipz.zoo.util.Entity;

public class Ration extends Entity {

	private final Animal animal;
	private Map<Product, Float> products = new HashMap<>();

	public Ration(Animal animal) {
		this.animal = animal;
	}

	public boolean addProduct(Product product, float amount) {
		if(product == null){
			throw new IllegalArgumentException("product");
		}
		return null == products.put(product, amount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(animal + "\n");
		products.entrySet().forEach(e -> sb.append("Product = " + e.getKey() + ", amount: " + e.getValue() + "\n"));
		return sb.toString();
	}
}

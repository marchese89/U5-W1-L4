package com.epicode.U5D2.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@DiscriminatorValue("pizza")
public class Pizza extends Item {
	private String name;
	@ManyToMany
	@JoinTable(
			name="pizza_topping",
			joinColumns = @JoinColumn(name="pizza_id"),
			inverseJoinColumns = @JoinColumn(name="topping_id")
	)
	private List<Topping> toppingList;
	private boolean isXl = false;

	@ManyToMany(mappedBy = "pizzaList")
	List<Menu> menuList;

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(700, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
	}

	@Override
	public int getCalories() {
		return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
	}

	@Override
	public double getPrice() {
		return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}

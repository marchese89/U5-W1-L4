package com.epicode.U5D2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("topping")
public class Topping extends Item {
	private String name;

	public Topping(String name, int calories, double price) {
		super(calories, price);
		this.name = name;
	}

	@ManyToMany(mappedBy = "toppingList")
	List<Menu> menuList;

	@ManyToMany(mappedBy = "toppingList")
	private List<Pizza> pizzasList;

	@Override
	public String toString() {
		return "Topping{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}

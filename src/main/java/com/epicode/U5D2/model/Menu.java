package com.epicode.U5D2.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
@Entity
@Table(name = "menus")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToMany
	@JoinTable(
			name="pizzas_menu",
			joinColumns = @JoinColumn(name="menu_id"),
			inverseJoinColumns = @JoinColumn(name="pizza_id")
	)
	@Autowired
	private List<Pizza> pizzaList;
	@ManyToMany
	@JoinTable(
			name="drinks_menu",
			joinColumns = @JoinColumn(name="menu_id"),
			inverseJoinColumns = @JoinColumn(name="drink_id")
	)
	@Autowired
	private List<Drink> drinkList;
	@ManyToMany
	@JoinTable(
			name="toppings_menu",
			joinColumns = @JoinColumn(name="menu_id"),
			inverseJoinColumns = @JoinColumn(name="topping_id")
	)
	@Autowired
	private List<Topping> toppingList;

	public void printMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		this.pizzaList.forEach(System.out::println);
		System.out.println();

		System.out.println("TOPPINGS");
		this.toppingList.forEach(System.out::println);
		System.out.println();

		System.out.println("DRINKS");
		this.drinkList.forEach(System.out::println);
		System.out.println();

	}
}

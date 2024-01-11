package com.epicode.U5D2.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="item_type")
@Table(name = "menu_items")
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	protected int calories;
	protected double price;

	public Item(int calories, double price) {
		this.calories = calories;
		this.price = price;
	}

}

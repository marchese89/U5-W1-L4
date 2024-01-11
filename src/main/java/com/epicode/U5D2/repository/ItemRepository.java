package com.epicode.U5D2.repository;

import com.epicode.U5D2.model.Drink;
import com.epicode.U5D2.model.Item;
import com.epicode.U5D2.model.Pizza;
import com.epicode.U5D2.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("SELECT p FROM Pizza p ")
    List<Pizza> getAllPizzas();

    @Query("SELECT d FROM Drink d")
    List<Drink> getAllDrinks();

    @Query("SELECT t FROM Topping t")
    List<Topping> getAllToppings();
}

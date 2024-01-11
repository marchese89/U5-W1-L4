package com.epicode.U5D2.repository;

import com.epicode.U5D2.model.Drink;
import com.epicode.U5D2.model.Menu;
import com.epicode.U5D2.model.Pizza;
import com.epicode.U5D2.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {

    @Query("SELECT p FROM Menu m JOIN m.pizzaList p WHERE m.id = :id")
    List<Pizza> getAllPizzas(long id);

    @Query("SELECT p FROM Menu m JOIN m.drinkList p WHERE m.id = :id")
    List<Drink> getAllDrinks(long id);

    @Query("SELECT p FROM Menu m JOIN m.toppingList p WHERE m.id = :id")
    List<Topping> getAllToppings(long id);
}

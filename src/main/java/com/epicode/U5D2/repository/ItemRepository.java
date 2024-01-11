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
    @Query("SELECT i FROM Item i WHERE i.item_type = 'pizza'")
    List<Pizza> getAllPizzas();

    @Query("SELECT i FROM Item i WHERE i.item_type = 'drink'")
    List<Drink> getAllDrinks();

    @Query("SELECT i FROM Item i WHERE i.item_type = 'topping'")
    List<Topping> getAllToppings();
}

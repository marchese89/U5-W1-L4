package com.epicode.U5D2.service;

import com.epicode.U5D2.model.*;
import com.epicode.U5D2.repository.ItemRepository;
import com.epicode.U5D2.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public Iterable<Menu> getAll(){
        return menuRepository.findAll();
    }

    public List<Pizza> getAllPizzas(long id){
        return menuRepository.getAllPizzas(id);
    }

    public List<Drink> getAllDrinks(long id){
        return menuRepository.getAllDrinks(id);
    }

    public List<Topping> getAllToppings(long id){
        return menuRepository.getAllToppings(id);
    }

    public Optional<Menu> getById(long id){
        return menuRepository.findById(id);
    }

    public Menu create(Menu menu){
        return menuRepository.save(menu);
    }

    public Optional<Menu> update(long id, Menu menu){
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if(menuOptional.isEmpty()){
            return Optional.empty();
        }

        menuOptional.get().setDrinkList(menu.getDrinkList());
        menuOptional.get().setPizzaList(menu.getPizzaList());
        menuOptional.get().setToppingList(menu.getToppingList());
        menuRepository.save(menuOptional.get());

        return  menuOptional;
    }

    public Boolean delete(long id){
        Optional<Menu> menuOptional = menuRepository.findById(id);
        if(menuOptional.isEmpty()){
            return false;
        }

        menuRepository.delete(menuOptional.get());

        return true;
    }
}

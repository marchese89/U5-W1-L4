package com.epicode.U5D2.service;

import com.epicode.U5D2.model.Drink;
import com.epicode.U5D2.model.Item;
import com.epicode.U5D2.model.Pizza;
import com.epicode.U5D2.model.Topping;
import com.epicode.U5D2.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public Iterable<Item> getAll(){
        return itemRepository.findAll();
    }

    public List<Pizza> getAllPizzas(){
        return itemRepository.getAllPizzas();
    }

    public List<Drink> getAllDrinks(){
        return itemRepository.getAllDrinks();
    }

    public List<Topping> getAllToppings(){
        return itemRepository.getAllToppings();
    }

    public Optional<Item> getById(long id){
        return itemRepository.findById(id);
    }

    public Item create(Item item){
        System.out.println("provo a creare un Item");
        return itemRepository.save(item);
    }

    public Optional<Item> update(long id, Item item){
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isEmpty()){
            return Optional.empty();
        }

        itemOptional.get().setCalories(item.getCalories());
        itemOptional.get().setPrice(item.getPrice());
        itemRepository.save(itemOptional.get());

        return  itemOptional;
    }

    public Boolean delete(long id){
        Optional<Item> itemOptional = itemRepository.findById(id);
        if(itemOptional.isEmpty()){
            return false;
        }

        itemRepository.delete(itemOptional.get());

        return true;
    }
}

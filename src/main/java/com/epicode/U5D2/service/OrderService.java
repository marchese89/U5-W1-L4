package com.epicode.U5D2.service;

import com.epicode.U5D2.model.*;
import com.epicode.U5D2.repository.MenuRepository;
import com.epicode.U5D2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Iterable<Order> getAll(){
        return orderRepository.findAll();
    }

    public List<Item> getAllItems(long id){
        return orderRepository.getAllItems(id);
    }


    public Optional<Order> getById(long id){
        return orderRepository.findById(id);
    }

    public Order create(Order menu){
        return orderRepository.save(menu);
    }

    public Optional<Order> update(long id, Order menu){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isEmpty()){
            return Optional.empty();
        }

        orderOptional.get().setOrderedProducts(menu.getOrderedProducts());
        orderOptional.get().setState(menu.getState());
        orderOptional.get().setTable(menu.getTable());
        orderOptional.get().setNumCoperti(menu.getNumCoperti());
        orderOptional.get().setNumeroOrdine(menu.getNumeroOrdine());
        orderOptional.get().setOraAcquisizione(menu.getOraAcquisizione());
        orderRepository.save(orderOptional.get());

        return  orderOptional;
    }

    public Boolean delete(long id){
        Optional<Order> menuOptional = orderRepository.findById(id);
        if(menuOptional.isEmpty()){
            return false;
        }

        orderRepository.delete(menuOptional.get());

        return true;
    }
}

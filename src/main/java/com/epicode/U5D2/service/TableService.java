package com.epicode.U5D2.service;

import com.epicode.U5D2.model.Item;
import com.epicode.U5D2.model.Order;
import com.epicode.U5D2.model.Table;
import com.epicode.U5D2.repository.OrderRepository;
import com.epicode.U5D2.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    TableRepository tableRepository;

    public Iterable<Table> getAll(){
        return tableRepository.findAll();
    }


    public Optional<Table> getById(long id){
        return tableRepository.findById(id);
    }

    public Table create(Table table){
        return tableRepository.save(table);
    }

    public Optional<Table> update(long id, Table table){
        Optional<Table> orderOptional = tableRepository.findById(id);
        if(orderOptional.isEmpty()){
            return Optional.empty();
        }

        orderOptional.get().setFree(table.isFree());
        orderOptional.get().setNumTable(table.getNumTable());
        orderOptional.get().setCostoCoperto(table.getCostoCoperto());
        orderOptional.get().setNumMaxCoperti(table.getNumMaxCoperti());
        tableRepository.save(orderOptional.get());

        return  orderOptional;
    }

    public Boolean delete(long id){
        Optional<Table> menuOptional = tableRepository.findById(id);
        if(menuOptional.isEmpty()){
            return false;
        }

        tableRepository.delete(menuOptional.get());

        return true;
    }
}

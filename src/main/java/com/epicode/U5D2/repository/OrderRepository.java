package com.epicode.U5D2.repository;

import com.epicode.U5D2.model.Item;
import com.epicode.U5D2.model.Order;
import com.epicode.U5D2.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT b FROM Order o JOIN o.orderedProducts b WHERE o.id = :id")
    List<Item> getAllItems(long id);
}

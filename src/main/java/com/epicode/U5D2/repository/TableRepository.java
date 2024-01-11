package com.epicode.U5D2.repository;

import com.epicode.U5D2.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table,Long> {
}

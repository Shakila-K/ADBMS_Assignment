package com.orderPlacement.Order_Placement.repository;

import com.orderPlacement.Order_Placement.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Long> {
}

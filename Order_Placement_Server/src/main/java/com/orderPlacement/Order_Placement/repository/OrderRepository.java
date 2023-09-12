package com.orderPlacement.Order_Placement.repository;

import com.orderPlacement.Order_Placement.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Long> {
    @Modifying
    @Query("DELETE FROM OrderTable o WHERE o.userID = :userId")
    void deleteByUserId(Long userId);
    
    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM OrderTable o WHERE o.userID = :userId")
    boolean existsByUserId(Long userId);

}

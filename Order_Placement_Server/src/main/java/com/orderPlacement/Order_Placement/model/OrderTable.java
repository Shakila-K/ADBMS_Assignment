package com.orderPlacement.Order_Placement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "order_table")

public class OrderTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @Column (length = 5)
    private Long userID;

    @Column (length = 8)
    private Long itemID;

    @Column
    private LocalDate orderDate;
}

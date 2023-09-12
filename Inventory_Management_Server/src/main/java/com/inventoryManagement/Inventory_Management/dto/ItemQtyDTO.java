package com.inventoryManagement.Inventory_Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemQtyDTO {

    private Long itemID;
    private int quantity;
}

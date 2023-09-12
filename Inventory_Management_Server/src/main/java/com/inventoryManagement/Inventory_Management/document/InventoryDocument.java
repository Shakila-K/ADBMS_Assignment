package com.inventoryManagement.Inventory_Management.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class InventoryDocument {

    @Id
    private Long itemID;

    private String itemName;

    private double itemPrice;

    private int availableQuantity;
}

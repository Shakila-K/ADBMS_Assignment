package com.inventoryManagement.Inventory_Management.repository;

import com.inventoryManagement.Inventory_Management.document.InventoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryDocument, Long> {

}

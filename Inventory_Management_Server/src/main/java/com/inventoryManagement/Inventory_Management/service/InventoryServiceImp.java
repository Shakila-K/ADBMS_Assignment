package com.inventoryManagement.Inventory_Management.service;

import com.inventoryManagement.Inventory_Management.document.InventoryDocument;
import com.inventoryManagement.Inventory_Management.dto.ItemQtyDTO;
import com.inventoryManagement.Inventory_Management.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImp implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void createInventory(InventoryDocument inventoryItem) {
        this.inventoryRepository.save(inventoryItem);

    }

    @Override
    public InventoryDocument getInventory(Long itemID) {
        return this.inventoryRepository.findById(itemID).orElseThrow();

    }

    @Override
    public List<InventoryDocument> getAllInventory() {
        return this.inventoryRepository.findAll();

    }

    @Override
    public boolean isInStock(ItemQtyDTO itemQty) {
        InventoryDocument inventory = this.inventoryRepository.findById(itemQty.getItemID()).orElse(new InventoryDocument());
        return (inventory.getAvailableQuantity() >= itemQty.getQuantity());
    }

    @Override
    public InventoryDocument updateInventory(InventoryDocument inventoryItem) {
        return this.inventoryRepository.save(inventoryItem);

    }

    @Override
    public void updateQuantity(Long itemID, int qty) {
        InventoryDocument inventory = this.inventoryRepository.findById(itemID).orElseThrow();
        inventory.setAvailableQuantity(inventory.getAvailableQuantity()-qty);
        this.inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long itemID) {
        this.inventoryRepository.deleteById(itemID);
    }
}

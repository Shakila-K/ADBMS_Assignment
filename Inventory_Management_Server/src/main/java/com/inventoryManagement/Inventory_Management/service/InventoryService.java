package com.inventoryManagement.Inventory_Management.service;

import com.inventoryManagement.Inventory_Management.document.InventoryDocument;
import com.inventoryManagement.Inventory_Management.dto.ItemQtyDTO;

import java.util.List;

public interface InventoryService {

    public void createInventory(InventoryDocument inventoryItem);

    public InventoryDocument getInventory(Long itemID);

    public List<InventoryDocument> getAllInventory();

    public boolean isInStock(ItemQtyDTO itemQty);

    public InventoryDocument updateInventory(InventoryDocument inventoryItem);

    public void updateQuantity (Long itemID, int qty);

    public void deleteInventory(Long itemID);
}

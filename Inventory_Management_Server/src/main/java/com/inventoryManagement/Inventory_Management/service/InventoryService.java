package com.inventoryManagement.Inventory_Management.service;

import com.inventoryManagement.Inventory_Management.document.InventoryDocument;

import java.util.List;

public interface InventoryService {

    public void createInventory(InventoryDocument inventoryItem);

    public InventoryDocument getInventory(Long itemID);

    public List<InventoryDocument> getAllInventory();

    public InventoryDocument updateInventory(InventoryDocument inventoryItem);

    public void deleteInventory(Long itemID);
}

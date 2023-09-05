package com.inventoryManagement.Inventory_Management.controller;

import com.inventoryManagement.Inventory_Management.document.InventoryDocument;
import com.inventoryManagement.Inventory_Management.service.InventoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents/")
public class InventoryController {

    @Autowired
    private InventoryServiceImp inventoryService;

    @PostMapping("createInventory")
    public ResponseEntity<Void> CreateInventory (@RequestBody InventoryDocument inventory){
        inventoryService.createInventory(inventory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("getInventory/{itemID}")
    public ResponseEntity<InventoryDocument> GetInventory (@PathVariable Long itemID){
        InventoryDocument inventory = this.inventoryService.getInventory(itemID);
        if (inventory != null){
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("getAllInventory")
    public ResponseEntity<List<InventoryDocument>> GetAllInventory(){
        return new ResponseEntity<List<InventoryDocument>>(this.inventoryService.getAllInventory(), HttpStatus.OK);

    }

    @PutMapping("updateInventory")
    public ResponseEntity<InventoryDocument> UpdateInventory(@RequestBody InventoryDocument inventory){
        InventoryDocument inventoryDocument = this.inventoryService.updateInventory(inventory);
        if(inventoryDocument != null){
            return new ResponseEntity<>(inventoryDocument, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteInventory/{itemID}")
    public ResponseEntity<Void> DeleteInventory(@PathVariable Long itemID){
        this.inventoryService.deleteInventory(itemID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

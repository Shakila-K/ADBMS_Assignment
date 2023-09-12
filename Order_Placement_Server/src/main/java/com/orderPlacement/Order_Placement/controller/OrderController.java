package com.orderPlacement.Order_Placement.controller;

import com.orderPlacement.Order_Placement.dto.NewOrderDTO;
import com.orderPlacement.Order_Placement.model.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.orderPlacement.Order_Placement.service.OrderServiceImp;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="/api/order/")
public class OrderController {

    @Autowired
    private OrderServiceImp orderService;

    @PostMapping("createOrder")
    public ResponseEntity<String> CreateOrder (@RequestBody NewOrderDTO order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("getOrder/{orderId}")
    public ResponseEntity<OrderTable> GetOrder (@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.readOrder(orderId));
    }

    @GetMapping("getAllOrders")
    public ResponseEntity<List<OrderTable>> GetAllOrders(){
        return ResponseEntity.ok(orderService.readAllOrders());
    }

    @PutMapping("updateOrder")
    public ResponseEntity<OrderTable> UpdateOrder (@RequestBody OrderTable order){
        return ResponseEntity.ok(orderService.updateOrder(order));
    }

    @DeleteMapping("deleteOrder/{orderId}")
    public ResponseEntity<String> DeleteOrder (@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.deleteOrder(orderId));
    }

    @DeleteMapping("deleteUser/{userId}")
    public ResponseEntity<String> DeleteUser (@PathVariable Long userId){
        return ResponseEntity.ok(this.orderService.deleteByUserId(userId));
    }

}

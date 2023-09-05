package controller;

import model.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.OrderServiceImp;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path ="/api/v1/")
public class OrderController {

    @Autowired
    private OrderServiceImp orderService;

    @PostMapping("createOrder")
    public ResponseEntity<String> CreateOrder (@RequestBody OrderTable order){
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

}

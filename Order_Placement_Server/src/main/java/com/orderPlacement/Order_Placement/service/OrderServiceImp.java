package com.orderPlacement.Order_Placement.service;

import com.orderPlacement.Order_Placement.dto.NewOrderDTO;
import com.orderPlacement.Order_Placement.model.OrderTable;
import com.orderPlacement.Order_Placement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    private final WebClient webClient;

    @Override
    public String createOrder(NewOrderDTO order) {

        OrderTable newOrder = new OrderTable();
        newOrder.setUserID(order.getUserID());
        newOrder.setItemID(order.getItemID());
        newOrder.setQuantity(order.getQuantity());
        newOrder.setOrderDate(java.time.LocalDate.now());

        boolean checkUser = Boolean.TRUE.equals(
                this.webClient.get()
                        .uri("http://localhost:8080/api/user/{userId}" , order.getUserID())
                        .retrieve()
                        .bodyToMono(boolean.class)
                        .block());

        //Check from the inventory if the item is available to order
        boolean available = Boolean.TRUE.equals(
                this.webClient.get()
                    .uri("http://localhost:8082/api/inventory/?itemID={itemID}&quantity={quantity}", order.getItemID(), order.getQuantity())
                    .retrieve()
                    .bodyToMono(boolean.class)
                    .block());

        if (checkUser){
            if(available){
                newOrder = orderRepository.save(newOrder);

                //updateQuantity
                this.webClient.put()
                        .uri("http://localhost:8082/api/inventory/updateQuantity?itemID={itemID}&quantity={quantity}", order.getItemID(), order.getQuantity())
                        .retrieve()
                        .toBodilessEntity()
                        .subscribe();

                return "Order Created. ID = " + newOrder.getOrderID();

            }
            else{
                return "No Stocks Available";
            }
        }
        else {
            return "Invalid user id";
        }

    }

    @Override
    public OrderTable readOrder(Long orderId) {
        if (orderRepository.existsById(orderId)){
            return orderRepository.findById(orderId).orElseThrow();
        }
        else{
            return null;
        }
    }

    @Override
    public List<OrderTable> readAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderTable updateOrder(OrderTable order) {
        if (orderRepository.existsById(order.getOrderID())){
            return orderRepository.save(order);
        }
        else{
            return null;
        }
    }

    @Override
    public String deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)){
            orderRepository.deleteById(orderId);
        }
        return "Order "+orderId+" Deleted";
    }

    @Override
    @Transactional
    public String deleteByUserId(Long userId) {

        if(this.orderRepository.existsByUserId(userId)){
            this.orderRepository.deleteByUserId(userId);
            return "Orders of " +userId+" was deleted";
        }
        else{
            return "No orders found of " +userId;
        }
    }
}

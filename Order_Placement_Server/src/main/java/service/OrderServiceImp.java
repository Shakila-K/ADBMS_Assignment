package service;

import model.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String createOrder(OrderTable order) {
        orderRepository.save(order);
        return "Order Created";
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
}

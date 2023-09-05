package com.orderPlacement.Order_Placement.service;

import com.orderPlacement.Order_Placement.model.OrderTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public String createOrder (OrderTable order);

    public OrderTable readOrder (Long orderId);

    public List<OrderTable> readAllOrders ();

    public OrderTable updateOrder (OrderTable order);

    public String deleteOrder (Long orderId);

}

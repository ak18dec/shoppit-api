package com.shoppit.order_service.service;

import com.shoppit.order_service.entity.Order;
import com.shoppit.order_service.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(Long userId, List<OrderItem> items);
    Optional<Order> getOrderById(Long id);
    List<Order> getOrdersByUser(Long userId);
    List<Order> getAllOrders();
    Order updateOrderStatus(Long orderId, String status);
    void cancelOrder(Long orderId);
}

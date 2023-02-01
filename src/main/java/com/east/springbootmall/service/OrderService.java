package com.east.springbootmall.service;

import com.east.springbootmall.dto.CreateOrderRequest;
import com.east.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

package com.east.springbootmall.service;

import com.east.springbootmall.dto.CreateOrderRequest;
import com.east.springbootmall.dto.OrderQuerParams;
import com.east.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQuerParams orderQuerParams);

    List<Order> getOrders(OrderQuerParams orderQuerParams);


    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);


}

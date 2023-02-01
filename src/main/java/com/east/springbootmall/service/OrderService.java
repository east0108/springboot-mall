package com.east.springbootmall.service;

import com.east.springbootmall.dto.CreateOrderRequest;

public interface OrderService {


    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

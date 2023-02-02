package com.east.springbootmall.dao;

import com.east.springbootmall.dto.OrderQuerParams;
import com.east.springbootmall.model.Order;
import com.east.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {


    Integer countOrder(OrderQuerParams orderQuerParams);

    List<Order> getOrders(OrderQuerParams orderQuerParams);



    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId , Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}

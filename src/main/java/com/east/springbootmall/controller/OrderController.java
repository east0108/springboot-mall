package com.east.springbootmall.controller;

import com.east.springbootmall.dto.CreateOrderRequest;
import com.east.springbootmall.dto.OrderQuerParams;
import com.east.springbootmall.model.Order;
import com.east.springbootmall.service.OrderService;
import com.east.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrders(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "10") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){

        OrderQuerParams orderQuerParams = new OrderQuerParams();
        orderQuerParams.setUserId(userId);
        orderQuerParams.setLimit(limit);
        orderQuerParams.setOffset(offset);

        //取得order list
        List<Order> orderList = orderService.getOrders(orderQuerParams);

        //取得order 總數
        Integer count = orderService.countOrder(orderQuerParams);

        //分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);

    }





    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createdOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){
     Integer orderId = orderService.createOrder(userId,createOrderRequest);

        Order order = orderService.getOrderById(orderId);

    return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }

}


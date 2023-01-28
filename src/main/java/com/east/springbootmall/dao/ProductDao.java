package com.east.springbootmall.dao;

import com.east.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}

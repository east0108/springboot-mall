package com.east.springbootmall.dao;

import com.east.springbootmall.dto.ProductRequest;
import com.east.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}

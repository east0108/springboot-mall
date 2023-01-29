package com.east.springbootmall.service;

import com.east.springbootmall.dto.ProductRequest;
import com.east.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);



}

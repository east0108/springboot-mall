package com.east.springbootmall.service;

import com.east.springbootmall.dto.ProductRequest;
import com.east.springbootmall.model.Product;

import java.util.List;

public interface ProductService {


    List<Product> getProducts();


    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);





}

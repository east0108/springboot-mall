package com.east.springbootmall.service.impl;

import com.east.springbootmall.dao.ProductDao;
import com.east.springbootmall.dto.ProductRequest;
import com.east.springbootmall.model.Product;
import com.east.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }


    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {

        productDao.deleteProductById(productId);
    }
}

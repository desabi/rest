package com.abi.feigndemo.service;

import com.abi.feigndemo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> read();
    Product read(Integer id);
}

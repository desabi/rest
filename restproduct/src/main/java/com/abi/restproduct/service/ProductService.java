package com.abi.restproduct.service;

import com.abi.restproduct.entity.Product;
import com.abi.restproduct.model.ProductRequest;

import java.util.List;

public interface ProductService {
    Product create (ProductRequest productRequest);
    List<Product> read();
    Product read(Integer id);
    Product update (ProductRequest productRequest);
    void delete(Integer id);
}

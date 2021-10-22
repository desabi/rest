package com.abi.feigndemo.service;

import com.abi.feigndemo.clients.ProductClient;
import com.abi.feigndemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // inject feign client
    @Autowired
    private ProductClient productClient;

    @Override
    public List<Product> read() {
        return productClient.read();
    }

    @Override
    public Product read(Integer id) {
        return productClient.read(id);
    }

}

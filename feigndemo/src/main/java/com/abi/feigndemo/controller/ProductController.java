package com.abi.feigndemo.controller;

import com.abi.feigndemo.model.Product;
import com.abi.feigndemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-client")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/read")
    public List<Product> read(){
        return productService.read();
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable("id") Integer id){
        return productService.read(id);
    }

}

package com.abi.feigndemo.clients;

import com.abi.feigndemo.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rest-product", url = "localhost:8080")
public interface ProductClient {

    @GetMapping("/product/read")
    public List<Product> read();

    @GetMapping("/product/read/{id}")
    public Product read(@PathVariable("id") Integer id);
}

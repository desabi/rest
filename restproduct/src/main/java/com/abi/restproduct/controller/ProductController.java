package com.abi.restproduct.controller;

import com.abi.restproduct.entity.Product;
import com.abi.restproduct.model.ProductRequest;
import com.abi.restproduct.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        String message = "Service Product working";
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest productRequest) {
        Product product = productService.create(productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Product>> read(){
        List<Product> productList = productService.read();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Product> read(@PathVariable("id") Integer id){
        Product productReaded = productService.read(id);
        return new ResponseEntity<>(productReaded, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@Valid @RequestBody ProductRequest productRequest){
        Product productUpdated = productService.update(productRequest);
        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

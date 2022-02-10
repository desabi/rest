package com.abi.restproduct.service;

import com.abi.restproduct.entity.Product;
import com.abi.restproduct.model.ProductRequest;
import com.abi.restproduct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(ProductRequest productRequest) {
        Product product = new Product(productRequest);
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product read(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product update(ProductRequest productRequest) {
        Product productToUpdate = new Product(productRequest);
        return productRepository.save(productToUpdate);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
        log.info("Producto con id {} borrado", id);
    }
}

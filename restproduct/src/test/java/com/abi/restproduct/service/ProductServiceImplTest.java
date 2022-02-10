package com.abi.restproduct.service;

import com.abi.restproduct.entity.Product;
import com.abi.restproduct.model.ProductRequest;
import com.abi.restproduct.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Producto Service Test")
class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productServiceImpl;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName(" Obtener productos")
    void getAllProducts() {
        List<Product> productList = Arrays.asList(
                new Product(1, "Samsung Galaxy A71", "SmartPhone", 9000.5, 4),
                new Product(2, "Asus X513EA", "Laptop", 23000.8, 3),
                new Product(3, "Sony WF-XB700", "Headphones", 2000.5, 1),
                new Product(4, "Garmin Forerunner 55", "Sport watch", 5200.99, 2));

        // Mockito
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        List<Product> products = productServiceImpl.read();
        // JUnit
        assertNotNull(products);
        assertEquals(4, products.size());
        Mockito.verify(productRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName(" Obtener producto por id")
    void getProductById() {
        Product theProduct = new Product(2, "Asus X513EA", "Laptop", 23000.8, 3);
        Mockito.when(productRepository.findById(2)).thenReturn(Optional.of(theProduct));
        Product productReaded = productServiceImpl.read(2);

        assertEquals("Laptop", productReaded.getDescription());
        assertEquals(3, productReaded.getQuantity());
    }

    @Test
    @DisplayName(" Guardar producto")
    void saveProduct() {
        ProductRequest productRequest= new ProductRequest("Sony WF-XB700", "Headphones", 2000.5, 1);
        Product product = new Product(productRequest);
        productServiceImpl.create(productRequest);
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }
}
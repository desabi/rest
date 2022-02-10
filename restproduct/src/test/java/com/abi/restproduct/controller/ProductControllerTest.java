package com.abi.restproduct.controller;

import com.abi.restproduct.entity.Product;
import com.abi.restproduct.model.ProductRequest;
import com.abi.restproduct.service.ProductService;
import com.abi.restproduct.service.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductController.class)
@DisplayName("Product Controller Test")
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deberia retornar mensaje de index")
    void shouldReturnIndexMessage() throws Exception {
        this.mockMvc
                .perform(get("/products/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(
                                Matchers.containsString("Service Product working")
                        )
                );
    }

    @Test
    @DisplayName("Deberia obtener producto con id 2")
    void shouldReturnProduct2() throws Exception {
        Product theProduct = new Product(2, "Asus X513EA", "Laptop", 23000.8, 3);

        Mockito.when(productService.read(2)).thenReturn(theProduct);

        this.mockMvc.perform(get("/products/2"))
                //.andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Deberia obtener producto con id 3")
    void shouldReturnProduct3() throws Exception {
        Product theProduct = new Product(3, "Sony WF-XB700", "Headphones",
                                        2000.5, 1);

        Mockito.when(productService.read(3)).thenReturn(theProduct);

        MvcResult mvcResult = this.mockMvc
                .perform(get("/products/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Headphones"))
                .andExpect(jsonPath("$.name").value("Sony WF-XB700"))
                .andReturn();

        assertEquals("application/json",
                mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("Deberia guardar producto")
    void shouldSaveProduct() throws Exception {
        ProductRequest productRequest = new ProductRequest("Garmin Forerunner 55", "Sport watch",
                                                            5200.99, 2);
        Product productSaved = new Product(4, "Garmin Forerunner 55", "Sport watch",
                                                            5200.99, 2);

        Mockito.when(productService.create(productRequest)).thenReturn(productSaved);

        this.mockMvc
                .perform(
                        post("/products")
                                .accept(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(productRequest))
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(5200.99));
    }

    @Test
    @DisplayName("Deberia obtener todos los productos")
    void shouldGetAllProducts() throws Exception {
        List<Product> productList = Arrays.asList(
                new Product(1, "Samsung Galaxy A71", "SmartPhone", 9000.5, 4),
                new Product(2, "Asus X513EA", "Laptop", 23000.8, 3),
                new Product(3, "Sony WF-XB700", "Headphones", 2000.5, 1),
                new Product(4, "Garmin Forerunner 55", "Sport watch", 5200.99, 2));

        Mockito.when(productService.read()).thenReturn(productList);

        this.mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(4))
                .andExpect(jsonPath("$[0].description").value("SmartPhone"))
                .andExpect(jsonPath("$[0].name").value("Samsung Galaxy A71"));
    }
}
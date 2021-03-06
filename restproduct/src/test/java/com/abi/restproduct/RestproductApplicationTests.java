package com.abi.restproduct;

import com.abi.restproduct.controller.ProductController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestproductApplicationTests {

	@Autowired
	private ProductController productController;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(productController);
	}

}

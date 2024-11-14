package com.Product.productApplication.Controller;


import com.Product.productApplication.Entity.ProductEntity;
import com.Product.productApplication.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTestHandler {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService pService;


	@Test
	public void testGetAllProducts() throws Exception{
		List<ProductEntity> products = Arrays.asList(
				new ProductEntity("1234", "Oreo", 30, "Food"),
				new ProductEntity("4567", "Water Bottle", 3000, "Accessories")
		);

		when(pService.getAllProducts()).thenReturn(products);

		mockMvc.perform(get("/api/v1/products")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Oreo"))
				.andExpect(jsonPath("$[1].name").value("Water Bottle"));
	}

	@Test
	public void testGetProductById() throws Exception{
		ProductEntity product =
				new ProductEntity("1234", "Oreo", 30, "Food");

		when(pService.getProductById("1234")).thenReturn(product);

		mockMvc.perform(get("/api/v1/products/100")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name")
						.value("Oreo"));


	}

}

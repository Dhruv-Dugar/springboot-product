package com.Product.productApplication.Repository;


import com.Product.productApplication.Entity.ProductEntity;
import com.Product.productApplication.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Transactional
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository pRepo;

	private ProductEntity product;

	@BeforeEach
	void setUp(){
		product = new ProductEntity("1234", "Oreo", 30, "Food");
		pRepo.save(product);
	}

	@Test
	void testFindById_Found(){
		Optional<ProductEntity> foundProduct = pRepo.findById("1234");


		assertTrue(foundProduct.isPresent());
		assertEquals("Oreo", foundProduct.get().getName());
	}



}

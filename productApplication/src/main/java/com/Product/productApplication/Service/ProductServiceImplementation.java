package com.Product.productApplication.Service;


import com.Product.productApplication.Controller.ProductController;
import com.Product.productApplication.Entity.ProductEntity;
import com.Product.productApplication.Error.InvalidInputException;
import com.Product.productApplication.Error.ProductNotFoundException;
import com.Product.productApplication.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService{
	private final ProductRepository pRepo;

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImplementation.class);


	@Autowired
	public ProductServiceImplementation(ProductRepository pRepo){
		this.pRepo = pRepo;
	}


	public List<ProductEntity> getAllProducts(){
		return pRepo.findAll();
	}

	public ProductEntity getProductById(String id){
		return pRepo.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Unable to find Product by Id: " + id));
	}

	public ProductEntity createProduct(ProductEntity p){
		p.setId(UUID.randomUUID().toString());
		logger.info("Created withID{}",p.getId());
		return pRepo.save(p);
	}

	public ProductEntity updateProductById(String id, ProductEntity p){
		ProductEntity p1 = pRepo.findById(id).orElseThrow(() -> new InvalidInputException("No product with the id: " + id));
		p1.setName(p.getName());
		p1.setCategory(p.getCategory());
		p1.setPrice(p.getPrice());

		return pRepo.save(p1);
	}

	public void deleteProductById(String id){
		ProductEntity p = pRepo.findById(id).orElseThrow(() -> new RuntimeException("No product has the ID: " + id));

		pRepo.delete(p);
	}
}

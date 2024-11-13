package com.Product.productApplication.Service;


import com.Product.productApplication.Entity.ProductEntity;
import com.Product.productApplication.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService{
	private final ProductRepository pRepo;

	@Autowired
	public ProductServiceImplementation(ProductRepository pRepo){
		this.pRepo = pRepo;
	}


	public List<ProductEntity> getAllProducts(){
		return pRepo.findAll();
	}

	public ProductEntity getProductById(String id){
		return pRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Unable to find Product by Id: " + id));
	}

	public ProductEntity createProduct(ProductEntity p){
		p.setId(UUID.randomUUID().toString());
		return pRepo.save(p);
	}

	public ProductEntity updateProductById(String id, ProductEntity p){
		ProductEntity p1 = pRepo.findById(id).orElseThrow(() -> new RuntimeException("No product with the id: " + id));
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

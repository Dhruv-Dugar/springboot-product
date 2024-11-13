package com.Product.productApplication.Service;

import com.Product.productApplication.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
	// will have all the name of the functions we need to implement
	List<ProductEntity> getAllProducts();
	ProductEntity getProductById(String id);
	ProductEntity createProduct(ProductEntity p);
	ProductEntity updateProductById(String id, ProductEntity p);
	void deleteProductById(String id);

}

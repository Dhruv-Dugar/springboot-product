package com.Product.productApplication.Controller;


import com.Product.productApplication.Entity.ProductEntity;
import com.Product.productApplication.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	private final ProductService pService;

	@Autowired
	public ProductController(ProductService pService){
		this.pService = pService;
	}

	@GetMapping
	public List<ProductEntity> getAllProducts(){
		return pService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ProductEntity getProductById(@PathVariable String id){
		return pService.getProductById(id);
	}

	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity p){
		return pService.createProduct(p);
	}

	@PutMapping("/{id}")
	public ProductEntity updateProductById(@PathVariable String id, @RequestBody ProductEntity p){
		return pService.updateProductById(id, p);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable String id){
		pService.deleteProductById(id);
		return ResponseEntity.noContent().build();
	}
}

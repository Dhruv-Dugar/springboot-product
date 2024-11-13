package com.Product.productApplication.Repository;


import com.Product.productApplication.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// providing JPA based CRUD operations in an easier way to the ProductController
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}

package com.Product.productApplication.Error;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String id){
        super("Product not found with id" + id);
    }
}

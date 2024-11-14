package com.Product.productApplication.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductEntity {
	@Id
	private String id;
	private String name;
	private int price;
	private String category;

	public String getId() {
		return id;
	}

	public ProductEntity(String id, String name, int price, String category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}

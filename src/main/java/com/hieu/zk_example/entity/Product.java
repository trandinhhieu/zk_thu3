package com.hieu.zk_example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	
	@Column(name = "name", nullable = false)
	private String name;
	

	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "image", nullable = true)
	private String image;
	

	@Column(name = "price", nullable = false)
	private Integer price;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "category_id",nullable = false)
	private int category;
	
	@Override
	public String toString() {
		return "Product [category=" + category + ", id=" + id + ", name=" + name + ", description=" + description
				+ ", image=" + image + ", price=" + price + ", quantity=" + quantity + "]";
	}

	public Product() {
		super();
		this.image = null;
	}
	
	public Product(String name, String description, int price, String image, int quantity, int category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
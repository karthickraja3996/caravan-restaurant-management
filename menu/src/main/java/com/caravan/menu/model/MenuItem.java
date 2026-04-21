package com.caravan.menu.model;

import jakarta.persistence.*;

@Entity
@Table(name="menu_items")
public class MenuItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String category;
	private Double price;
	private Boolean availability;
	@Column(length=1000)
	private String description;
	private String imageUrl;
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public MenuItem() {
		
	}
	
	public MenuItem(String name,String category,Double price,Boolean availability,String description,String imageUrl) {
		this.availability=availability;
		this.category=category;
		this.description=description;
		this.name=name;
		this.price=price;
		this.imageUrl=imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

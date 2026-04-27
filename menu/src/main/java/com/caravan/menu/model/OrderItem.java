package com.caravan.menu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantity;
	private Double subtotal;
	@ManyToOne
	@JoinColumn(name="menu_item_id")
	private MenuItem menuItems;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	public MenuItem getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(MenuItem menuItems) {
		this.menuItems = menuItems;
	}
	public OrderItem() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public MenuItem getMenuItem() {
		return menuItems;
	}

	public void setMenuItem(MenuItem menuItems) {
		this.menuItems = menuItems;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
}

package com.caravan.menu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.caravan.menu.model.Order;

public interface OrderRepository extends JpaRepository<Order ,Long> {

	
	List<Order> findByCustomerNameContainingIgnoreCase(String customerName);
	List<Order> findByStatus(String status);
	List<Order> findByCustomerNameContainingIgnoreCaseAndStatus(String customerName, String status);
	
	long countByStatus(String status);
	@Query("SELECT SUM(o.totalAmount) FROM Order o")
	Double getTotalRevenue();
	
}

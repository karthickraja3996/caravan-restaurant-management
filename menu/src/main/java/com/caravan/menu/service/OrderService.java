package com.caravan.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caravan.menu.model.Order;
import com.caravan.menu.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	public List<Order> searchOrder(String customerName, String status){
		
		
		if(customerName != null && !customerName.isEmpty() && status != null && !status.isEmpty()) {
			return orderRepository.findByCustomerNameContainingIgnoreCaseAndStatus(customerName, status);
		}
		else if(customerName !=null && !customerName.isEmpty()) {
			return orderRepository.findByCustomerNameContainingIgnoreCase(customerName);
		}
		
		else if(status != null && !status.isEmpty()) {
			return orderRepository.findByStatus(status);
		}
		
		else {
			return orderRepository.findAll();
		}
	}
	
	public long getTotalOrders() {
		return orderRepository.count();
	}
	
	public long getPendingOrders() {
		return orderRepository.countByStatus("Pending");
	}
	
	public long getCompletedOrders() {
		return orderRepository.countByStatus("Completed");
	}
	
	public double getTotalRevenue() {
		Double revenue = orderRepository.getTotalRevenue();
		return revenue != null ? revenue : 0 ;
		
	}
}

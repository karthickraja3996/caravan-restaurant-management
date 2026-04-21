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
}

package com.caravan.menu.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caravan.menu.model.MenuItem;
import com.caravan.menu.model.Order;
import com.caravan.menu.model.OrderItem;
import com.caravan.menu.service.MenuService;
import com.caravan.menu.service.OrderService;


@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/add-order")
	public String showOrderForm(Model model) {
		model.addAttribute("order", new Order());
		return "add-order";
	}
	@PostMapping("/save-order")
	public String saveOrder(@ModelAttribute Order order) {
		order.setOrderDate(LocalDate.now());
		order.setStatus("Pending");
		orderService.saveOrder(order);
		return "redirect:/orders";
	}
	
	@GetMapping("/orders")
	public String viewOrders(Model model) {
		model.addAttribute("orders",orderService.getAllOrder());
		return "orders";
	}
	@GetMapping("/menu-order")
	public String showMenuOrderPage(Model model) {
		model.addAttribute("menuItems",menuService.getAllItem());
		model.addAttribute("order",new Order());
		return "menu-order";
	}
	
	@PostMapping("/place-order")
	public String placeOrder(@RequestParam String customerName, @RequestParam List<Long> menuItemId,@RequestParam List<Integer> quantity) {
		
		Order order = new Order();
		order.setCustomerName(customerName);
		order.setStatus("Pending");
		order.setOrderDate(LocalDate.now());
		List<OrderItem> orderItems = new ArrayList<>();
		double total = 0;
		
		for(int i=0 ; i < menuItemId.size() ;i++) {
			if(quantity.get(i)> 0) {
				
				MenuItem item = menuService.getMenuItemById(menuItemId.get(i));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setMenuItem(item);
				orderItem.setQuantity(quantity.get(i));
				
				double subTotal = item.getPrice() * quantity.get(i);
				orderItem.setSubtotal(subTotal);
				
				orderItem.setOrder(order);
				orderItems.add(orderItem);
				total+= subTotal; 
				
			}
		}
		order.setOrderItems(orderItems);
		
		for(OrderItem item : orderItems) {
			item.setOrder(order);
		}
		order.setTotalAmount(total);
		orderService.saveOrder(order);

		return "redirect:/orders";
	}
	
	
	@GetMapping("/order-details/{id}")
	public String viewOrderDetails(@PathVariable Long id,Model model) {
		Order order = orderService.getOrderById(id);

	//	System.out.println("ORDER ITEMS"+order.getOrderItems());
		model.addAttribute("order",order);
		
		return "order-details";
	}
	
	@GetMapping("/update-status/{id}")
	public String updateOrderStatus(@PathVariable Long id) {
		
		Order order = orderService.getOrderById(id);
		
		String currentStatus = order.getStatus();
		
		if(currentStatus.equalsIgnoreCase("Pending")) {
			order.setStatus("Preparing");
		}
		else if(currentStatus.equalsIgnoreCase("Preparing")) {
			order.setStatus("Completed");
		}
		
		orderService.saveOrder(order);
		
		return "redirect:/orders";
	}


}

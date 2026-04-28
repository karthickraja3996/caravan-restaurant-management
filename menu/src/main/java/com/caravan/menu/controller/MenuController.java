package com.caravan.menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caravan.menu.model.MenuItem;
import com.caravan.menu.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/menu")
	public String viewMenu(Model model) {
		
		//model is a container that collects the data 
		//menuItems is sending data to html where we used ${menuItems}
		model.addAttribute("menuItems", menuService.getAllItem());
		return "menu";
	}
	
	@GetMapping("/add-menu")
	public String showAddMenuForm(Model model) {
		model.addAttribute("menuItem", new MenuItem());
		return "add-menu";
	}
	
	@PostMapping("/save-menu")
	public String saveMenuItem(@ModelAttribute MenuItem menuItem) {
		menuService.saveMenuItem(menuItem);
		return "redirect:/menu";
	}
	
	@GetMapping("/delete-menu/{id}")
	public String deleteMenuItem(@PathVariable Long id) {
		menuService.deleteMenuItem(id);
		return "redirect:/menu";
	}
	
	@GetMapping("/edit-menu/{id}")
	public String showEditMenu(@PathVariable Long id,Model model) {
		MenuItem menuItem = menuService.getMenuItemById(id);
		model.addAttribute("menuItem",menuItem);
		return "edit-menu";
	}
	
	@PostMapping("/update-menu")
	public String updateMenuItem(@ModelAttribute MenuItem menuItem) {
		menuService.saveMenuItem(menuItem);
		return "redirect:/menu";
	}
}

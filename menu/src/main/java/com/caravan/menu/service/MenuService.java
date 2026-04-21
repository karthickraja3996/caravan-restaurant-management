package com.caravan.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caravan.menu.model.MenuItem;
import com.caravan.menu.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public List<MenuItem> getAllItem(){
		return menuRepository.findAll();
	}
	
	public MenuItem saveMenuItem(MenuItem menuItem) {
		return menuRepository.save(menuItem);
	}
	
	public void deleteMenuItem(Long id) {
		menuRepository.deleteById(id);
	}
	
	public MenuItem getMenuItemById(Long id) {
		return menuRepository.findById(id).orElse(null);
	}
	
}

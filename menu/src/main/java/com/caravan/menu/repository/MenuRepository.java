package com.caravan.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caravan.menu.model.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem, Long> {

}

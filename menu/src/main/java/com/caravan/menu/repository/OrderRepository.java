package com.caravan.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caravan.menu.model.Order;

public interface OrderRepository extends JpaRepository<Order ,Long> {

}

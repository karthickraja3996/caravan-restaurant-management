# 🍽 Caravan Restaurant Management System

![Java](https://img.shields.io/badge/Java-Backend-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Framework-green)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)

---

## 📌 Project Overview

A full-stack restaurant management system built using Spring Boot.  
This application helps manage menu items, process customer orders, and track order status efficiently.

---

## 🚀 Features

### 🧾 Menu Management
- Add, edit, delete menu items
- Dynamic UI display using Thymeleaf

### 🛒 Order Processing
- Multi-item order creation
- Quantity-based calculation
- Automatic total price calculation

### 📊 Order Details
- Item-wise breakdown
- Subtotal calculation

### 🔄 Order Status Workflow
- Pending → Preparing → Completed
- Real-time status updates

### 🧩 Database Design
- One-to-Many (Order → OrderItems)
- Many-to-One (OrderItem → MenuItem)

---

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA (Hibernate)
- Thymeleaf
- MySQL

---

## 📸 Screenshots

### 🍽 Menu Page
![Menu](screenshots/menu-page.png)

### 🛒 Place Order
![Order](screenshots/place-order.png)

### 📋 Orders List
![Orders](screenshots/orders-list.png)

### 📊 Order Details
![Details](screenshots/order-details.png)

### 🔄 Status Update
![Status](screenshots/status-update.png)

---

## ▶️ How to Run

```bash
git clone https://github.com/karthickraja3996/caravan-restaurant-management.git
cd caravan-restaurant-management

package com.poly.lab6.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.entity.lab6.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}

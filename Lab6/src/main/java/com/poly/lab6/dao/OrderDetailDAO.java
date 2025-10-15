package com.poly.lab6.dao;

import com.poly.lab6.entity.lab6.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
}

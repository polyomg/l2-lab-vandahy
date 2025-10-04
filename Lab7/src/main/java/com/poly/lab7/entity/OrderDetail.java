package com.poly.lab7.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;
    @ManyToOne @JoinColumn(name = "productID")
    Product product;
    @ManyToOne @JoinColumn(name = "orderID")
    Order order;
}

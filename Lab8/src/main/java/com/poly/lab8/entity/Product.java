package com.poly.lab8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String image;
    Double price;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    Date createDate = new Date();
    Boolean available;
    @ManyToOne @JoinColumn(name = "category_id")
    Category category;
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}

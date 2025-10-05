package com.poly.lab6.entity.lab6;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Categories")
@Table
public class Category implements Serializable {
    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "category")
    List<Product> products;
}

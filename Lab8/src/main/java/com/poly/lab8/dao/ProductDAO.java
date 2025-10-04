package com.poly.lab8.dao;

import com.poly.lab8.entity.Product;
import com.poly.lab8.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
//    @Query("select p from Product p where p.price between ?1 and ?2")
//    List<Product> findByPrice(double minPrice, double maxPrice);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);//using DSL to shorter code

//    @Query("select p from Product p where p.name like ?1")
//    Page<Product> findByKeywords(String keywords, Pageable pageable);
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count "
            + " FROM Product o "
            + " GROUP BY o.category"
            + " ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}

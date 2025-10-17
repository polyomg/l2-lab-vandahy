package com.poly.lab6.dao;

import com.poly.lab6.entity.lab6.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryDAO extends JpaRepository<Category, String> {
}


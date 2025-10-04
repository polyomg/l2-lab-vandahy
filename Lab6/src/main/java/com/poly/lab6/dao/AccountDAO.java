package com.poly.lab6.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import poly.edu.entity.lab6.Account;

import java.util.List;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("select a from Account a where a.username = ?1")
    Account findByUsername(String username);
    @Query("select a from Account a ")
    List<Account> findAll();
}

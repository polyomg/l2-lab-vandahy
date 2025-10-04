package com.poly.lab8.dao;

import com.poly.lab8.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDAO extends JpaRepository<Account, String> {
    @Query("select a from Account a where a.username = ?1")
    Account findByUsername(String username);
    @Query("select a from Account a ")
    List<Account> findAll();
}

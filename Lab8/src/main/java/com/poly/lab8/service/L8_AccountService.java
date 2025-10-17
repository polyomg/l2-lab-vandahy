package com.poly.lab8.service;

import com.poly.lab8.entity.Account;

import java.util.List;

public interface L8_AccountService {
    Account findById(String username);
    List<Account> findAll();
}

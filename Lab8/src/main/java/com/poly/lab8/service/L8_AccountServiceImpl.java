package com.poly.lab8.service;

import com.poly.lab8.dao.AccountDAO;
import com.poly.lab8.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class L8_AccountServiceImpl implements L8_AccountService {
    @Autowired
    AccountDAO dao;
    @Override
    public Account findById(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }
}

package com.poly.lab5.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class L5_SessionService {
    @Autowired
    HttpSession session;

    public <T> T get(String name) {
        Object value = session.getAttribute(name);
        return (T) value;
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
        //the attribute already exists --> create
        // the attribute already exists --> update
    }

    public void remove(String name) {
        //if they attribute already exists, delete it
        //but else, no happened, programming still run normally
        if (session.getAttribute(name) != null) {
            session.removeAttribute(name);
            System.out.println("Removed attribute: " + name);
        } else {
            System.out.println("Attribute not found: " + name);
        }
    }

}

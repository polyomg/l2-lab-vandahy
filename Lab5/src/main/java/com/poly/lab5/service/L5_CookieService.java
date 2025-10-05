package com.poly.lab5.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class L5_CookieService {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse response;
    public Cookie getCookie(String name){
        if (request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
                if (cookie.getName().equalsIgnoreCase(name)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public String getValue(String name){
        Cookie cookie = this.getCookie(name);
        return cookie != null ? cookie.getValue() : null;
    }

    public Cookie add(String name, String value, int hours){
        Cookie cookie = new Cookie(name, value); //to create new cookie with name and value
        cookie.setMaxAge(hours * 60 * 60);//set life time of cookie (counted in seconds)
        cookie.setPath("/");//set the path which the cookie is valid
        // "/" means cookie is valid for the whole website
        response.addCookie(cookie); //send cookie to client (often by HttpsServletResponse)
        return cookie;
    }

    public void remove(String name){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equalsIgnoreCase(name)){
                    cookie.setMaxAge(0); //when set life time of cookie = 0, it means we're deleting it
                    cookie.setPath("/");// to ensure the deletion applies site-wide
                    response.addCookie(cookie);//to send the cookie back to the client to update that it deleted itx
                    break; //after removing, stop loop
                }
            }
        }
    }

}

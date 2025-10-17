package com.poly.lab5.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class L5_ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name); //get the value of a request parameter sent from client
        if (value != null && !value.isEmpty()) {//check if true
            return value; //return the value got from request
        }
        return defaultValue; //if false, return default value that we set
    }

    public Integer getInt(String name, Integer defaultValue) {
        String value = request.getParameter(name);
        if (value != null && !value.isEmpty()) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer for parameter " + name + ": " + value);
            }
        }
        return defaultValue;
    }

    public Double getDouble(String name, Double defaultValue) {
        String value = request.getParameter(name);
        if (value != null && !value.isEmpty()) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid double for parameter " + name + ": " + value);
            }
        }
        return defaultValue;
    }

    public Boolean getBoolean(String name, Boolean defaultValue) {
        String value = request.getParameter(name);
        if (value != null && !value.isEmpty()) {
            if (value.equalsIgnoreCase("true")) {
                return true;
            } else if (value.equalsIgnoreCase("false")) {
                return false;
            }
        }
        return defaultValue;
    }

    public Date getDate(String name, String pattern) {
        String value = request.getParameter(name);
        if (value != null && !value.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                return sdf.parse(value);
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format for parameter " + name
                        + " with value: " + value
                        + ", expected pattern: " + pattern, e);
            }
        }
        return null;
    }

    public File save(MultipartFile file, String path) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        try {
            //To get the real path of web root
            String realPath = request.getSession().getServletContext().getRealPath(path);
            File dir = new File(realPath);


            if (!dir.exists()) {
                dir.mkdirs();//to create directory (folder)
            }

            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);
            return savedFile;
        }catch (Exception e){
            throw new RuntimeException("Error saving uploaded file: "
                    + file.getOriginalFilename(), e);
        }
    }

}

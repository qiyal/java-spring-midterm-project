package com.example.demo.controller;

import com.example.demo.entity.MyOrder;
import com.example.demo.service.implement.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    public boolean checkAdmin(String login, String password) {
        return adminService.checkAdmin(login, password);
    }
}

package com.example.demo.service.implement;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean checkAdmin(String login, String password) {
        Admin admin = adminRepository.getAdminByLoginAndPassword(login, password);
        return (admin != null);
    }
}

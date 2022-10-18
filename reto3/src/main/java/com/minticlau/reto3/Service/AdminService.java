package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Admin;
import com.minticlau.reto3.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdminAll() {
        return adminRepository.getAdminAll();
    }

    public Optional<Admin> getAdminId(Integer id) {
        return adminRepository.getAdminId(id);
    }

    public Admin saveAdmin(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.saveAdmin(admin);
        } else {
            Optional<Admin> adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if (adminAuxiliar.isEmpty()) {
                return adminRepository.saveAdmin(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin updateAdmin(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> adminAuxiliar = adminRepository.getAdminId(admin.getIdAdmin());
            if (!adminAuxiliar.isEmpty()) {
                if (admin.getEmail() != null) {
                    adminAuxiliar.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword() != null) {
                    adminAuxiliar.get().setPassword(admin.getPassword());
                }
                if (admin.getName() != null) {
                    adminAuxiliar.get().setName(admin.getName());
                }
                return adminRepository.saveAdmin(adminAuxiliar.get());
            }
        }
        return admin;
    }

    public boolean deleteAdmin(Integer adminId) {
        boolean flag = false;
        Optional<Admin> adminAuxiliar = adminRepository.getAdminId(adminId);
        if (adminAuxiliar.isPresent()) {
            adminRepository.deleteAdmin(adminAuxiliar.get());
        }
        return flag;

    }

}

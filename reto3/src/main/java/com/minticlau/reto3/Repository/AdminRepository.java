package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Admin;
import com.minticlau.reto3.Repository.Crud.AdminCrudRepositoryInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class AdminRepository {

    @Autowired
    private AdminCrudRepositoryInterface adminCrudRepositoryInterface;

    public List<Admin> getAdminAll() {
        return (List<Admin>) adminCrudRepositoryInterface.findAll();
    }

    public Optional<Admin> getAdminId(Integer id) {
        return adminCrudRepositoryInterface.findById(id);
    }

    public Admin saveAdmin(Admin admin) {
        return adminCrudRepositoryInterface.save(admin);
    }

    public void deleteAdmin(Admin admin) {
        adminCrudRepositoryInterface.delete(admin);

    }

}

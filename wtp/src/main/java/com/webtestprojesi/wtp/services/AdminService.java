package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.Admin;
import com.webtestprojesi.wtp.repos.AdminRepository;
//import com.webtestprojesi.wtp.requests.AdminUpdateRequest;
import com.webtestprojesi.wtp.requests.AdminUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    //AdminService link
    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    //Save newly created admins to the Repository
    public Admin createOneAdmin(Admin newAdmin) {

        return adminRepository.save(newAdmin);
    }

    //Retrieve records from repository
    public Admin getOneAdmin(Long adminId) {

        return adminRepository.findById(adminId).orElse(null);
    }

    //Update records in the repository
    public Admin updateOneAdmin(Long adminId, AdminUpdateRequest updateAdminRequest) {

        Optional<Admin> admin = adminRepository.findById(adminId);

        if(admin.isPresent()){
            Admin foundAdmin = admin.get();
            foundAdmin.setAdminName(updateAdminRequest.getAdminName());
            foundAdmin.setPassword(updateAdminRequest.getPassword());
            adminRepository.save(foundAdmin);
            return foundAdmin;
        }
        else{
            return null;
        }
    }

    //Delete records in the repository
    public void deleteById(Long adminId) {

        adminRepository.deleteById(adminId);
    }

}

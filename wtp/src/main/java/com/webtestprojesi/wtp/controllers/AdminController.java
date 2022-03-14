package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.Admin;
import com.webtestprojesi.wtp.requests.AdminUpdateRequest;
import com.webtestprojesi.wtp.services.AdminService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;
    //AdminService link
    public AdminController(AdminService adminService) {

        this.adminService = adminService;
    }

    //Send request to AdminService to pull all records from database
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    //Sending a request to the AdminService to create a new record in the database
    @PostMapping
    public Admin createAdmin(@RequestBody Admin newAdmin){

        return adminService.createOneAdmin(newAdmin);
    }

    //Submit request to AdminService to pull records from database
    @GetMapping("/{adminId}")
    public  Admin getOneAdmin(@PathVariable Long adminId){
        return adminService.getOneAdmin(adminId);
    }

    //Submitting a request to the AdminService to update records in the database
    @PutMapping("/{adminId}")
    public Admin updateOneAdmin(@PathVariable Long adminId, @RequestBody AdminUpdateRequest updateAdminRequest){

        return adminService.updateOneAdmin(adminId, updateAdminRequest);
    }

    //Submitting a request to the AdminService to delete records in the database
    @DeleteMapping("/{adminId}")
    public void deeleteOneAdmin(@PathVariable Long adminId){
        adminService.deleteById(adminId);
    }
}
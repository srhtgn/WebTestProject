package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.PermissionRequestDetail;
import com.webtestprojesi.wtp.requests.PermissionRequestDetailCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestDetailUpdateRequest;
import com.webtestprojesi.wtp.services.PermissoinRequestDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PermissionRequestDetailController {

    private final PermissoinRequestDetailService pRDService;
    //PermissionRequestDetailService link
    public PermissionRequestDetailController (PermissoinRequestDetailService pRDService){
        this.pRDService = pRDService;
    }

    //Send request to PermissionRequestDetailService to read data according to default parameters
    @GetMapping
    public List<PermissionRequestDetail> getAllPermissionRequests(@RequestParam Optional<Long> permissionRequestFormId, @RequestParam Optional<Long> employeeId){
        return pRDService.getAllPermissionRequestDetailWithParam(permissionRequestFormId, employeeId);
    }

    //Sending a request to the PermissionRequestDetailService to create a new record in the database
    @PostMapping
    public PermissionRequestDetail createOnePermissionRequestDetail(@RequestBody PermissionRequestDetailCreateRequest pRDCreateRequest){

        return pRDService.createOnePermissionRequestDetailById(pRDCreateRequest);
    }

    //Submit request to PermissionRequestDetailService to pull records from database
    @GetMapping("/{pRDId}")
    public PermissionRequestDetail getOnePermissionRequestDetail(@PathVariable Long pRDId){

        return pRDService.getOnePermissionRequestDetailById(pRDId);
    }

    //Submitting a request to the PermissionRequestDetailService to update records in the database
    @PutMapping("/{pRDId}")
    public PermissionRequestDetail updateOnePermissionRequestDetail(@PathVariable Long pRDId, @RequestBody PermissionRequestDetailUpdateRequest pRDUpdateRequest){
        return pRDService.updateOnePermissionRequestDetailById(pRDId, pRDUpdateRequest);
    }

    //Submitting a request to the PermissionRequestDetailService to delete records in the database
    @DeleteMapping("/{pRDId}")
    public void deleteOnePermissionRequestDetail(@PathVariable Long pRDId) {
        pRDService.deleteOnePermissionRequestDetailById(pRDId);
    }
}

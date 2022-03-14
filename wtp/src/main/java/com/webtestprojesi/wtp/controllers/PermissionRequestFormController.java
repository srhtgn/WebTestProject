package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import com.webtestprojesi.wtp.requests.PermissionRequestFormCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestFormUpdateRequest;
import com.webtestprojesi.wtp.services.PermissionRequestFormService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permissionRequestForms")
public class PermissionRequestFormController {

    private PermissionRequestFormService pRFService;

    public PermissionRequestFormController(PermissionRequestFormService pRFService){

        this.pRFService = pRFService;

    }

    @GetMapping
    public List<PermissionRequestForm> getAllPermissionRequestForms(){

        return pRFService.getAllPermissionRequestFormsById();
    }

    @PostMapping
    public PermissionRequestForm createOnePermissionRequestForm(@RequestBody PermissionRequestFormCreateRequest pRFCreateRequest){

        return pRFService.createOnePermissionRequestFormById(pRFCreateRequest);
    }

    @GetMapping("/{pRFId}")
    public PermissionRequestForm getOnePermissionRequestForm(@PathVariable Long pRFId){

        return pRFService.getOnePermissionRequestFormById(pRFId);
    }

    @PutMapping("/{pRFId}")
    public PermissionRequestForm updateOnePermissionRequestForm(@PathVariable Long pRFId, @RequestBody PermissionRequestFormUpdateRequest pRFUpdateRequest){
        return pRFService.updateOnePermissionRequestFormById(pRFId, pRFUpdateRequest);
    }

    @DeleteMapping("/{pRFId}")
        public void deleteOnePermissionRequestForm(@PathVariable Long pRFId){

        pRFService.deleteOnePermissionRequestFormById(pRFId);
    }
}

package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.MyPermissionRequests;
import com.webtestprojesi.wtp.entities.PermissionRequests;
import com.webtestprojesi.wtp.requests.PermissionRequestsCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestsUpdateRequest;
import com.webtestprojesi.wtp.services.PermissoinRequestsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/{permissionrequests")
public class PermissionRequestsController {

    private PermissoinRequestsService pRService;

    public PermissionRequestsController (PermissoinRequestsService pRService){
        this.pRService = pRService;
    }

    @GetMapping
    public List<PermissionRequests> getAllPermissionRequests(@RequestParam Optional<Long> permissionRequestFormId, @RequestParam Optional<Long> employeeId){
        return pRService.getAllPermissionRequestsWithParam(permissionRequestFormId, employeeId);
    }
    @PostMapping
    public PermissionRequests createOnePermissionRequests(@RequestBody PermissionRequestsCreateRequest pRCreateRequest){

        return pRService.createOnePermissionRequestsById(pRCreateRequest);
    }

    @GetMapping("/{pRId}")
    public PermissionRequests getOnePermissionRequests(@PathVariable Long pRId){

        return pRService.getOnePermissionRequestsById(pRId);
    }

    @PutMapping("/{pRId}")
    public PermissionRequests updateOnePermissionRequests(@PathVariable Long pRId, @RequestBody PermissionRequestsUpdateRequest pRUpdateRequest){
        return pRService.updateOnePermissionRequestsById(pRId, pRUpdateRequest);
    }

}

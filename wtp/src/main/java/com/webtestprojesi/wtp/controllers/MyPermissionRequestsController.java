package com.webtestprojesi.wtp.controllers;

import com.webtestprojesi.wtp.entities.MyPermissionRequests;
import com.webtestprojesi.wtp.requests.MyPermissionRequestsCreateRequest;
import com.webtestprojesi.wtp.requests.MyPermissionRequestsUpdateRequest;
//import com.webtestprojesi.wtp.services.MyPermissionRequestsService;
import com.webtestprojesi.wtp.services.MyPermissionRequestsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mypermissionrequestscontroller")
public class MyPermissionRequestsController {
    private MyPermissionRequestsService mPRService;

    public MyPermissionRequestsController(MyPermissionRequestsService myPermissoinRequestsService){
        this.mPRService = mPRService;
    }

    @GetMapping
    public List<MyPermissionRequests> getAllMyPermissionRequest(@RequestParam Optional<Long> permissionRequestFormId){
        return mPRService.getAllMyPermissionRequestsWithParam(permissionRequestFormId);
    }

    @PostMapping
    public MyPermissionRequests createOneMyPermissionRequests(@RequestBody MyPermissionRequestsCreateRequest mPRCreateRequest){

        return mPRService.createOneMyPermissionRequestsById(mPRCreateRequest);
    }

    @GetMapping("/{mPRId}")
    public MyPermissionRequests getOneMyPermissionRequests(@PathVariable Long mPRId) {

        return mPRService.getOneMyPermissionRequestsById(mPRId);
    }

    @PutMapping("/{mPRId}")
    public MyPermissionRequests updateOneMyPermissionRequests(@PathVariable Long mPRId,@RequestBody MyPermissionRequestsUpdateRequest mPRUpdateRequest){
        return mPRService.updateOneMyPermissionRequestsById(mPRId, mPRUpdateRequest);
    }

    @DeleteMapping("/{mPRId}")
    public void deleteOneMyPermissionRequests(@PathVariable Long mPRId) {
        mPRService.deleteOneMyPermissionRequestsById(mPRId);
    }
}

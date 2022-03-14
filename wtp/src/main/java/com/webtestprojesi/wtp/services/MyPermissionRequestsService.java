package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.MyPermissionRequests;
import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import com.webtestprojesi.wtp.repos.MyPermissionRequestsRepository;
import com.webtestprojesi.wtp.requests.MyPermissionRequestsCreateRequest;
import com.webtestprojesi.wtp.requests.MyPermissionRequestsUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyPermissionRequestsService {

    private final MyPermissionRequestsRepository mPRRepository;

    private final PermissionRequestFormService pRFService;

    public MyPermissionRequestsService(MyPermissionRequestsRepository mPRRepository, PermissionRequestFormService pRFService){
        this.mPRRepository = mPRRepository;
        this.pRFService = pRFService;
    }

    public List<MyPermissionRequests> getAllMyPermissionRequestsWithParam(Optional<Long> permissionRequestFormId) {

        if(permissionRequestFormId.isPresent()){

            return mPRRepository.findByPermisssionRequestFormId(permissionRequestFormId);
        }
        else {
            return mPRRepository.findAll();
        }
    }

    public MyPermissionRequests getOneMyPermissionRequestsById(Long mPRId) {
        return mPRRepository.findById(mPRId).orElse(null);
    }

    public MyPermissionRequests createOneMyPermissionRequestsById(MyPermissionRequestsCreateRequest mPRCreateRequest) {

        PermissionRequestForm permissionRequestForm = pRFService.getOnePermissionRequestFormById(mPRCreateRequest.getPermissionRequestFormId());

        if (permissionRequestForm != null){
            MyPermissionRequests toSave = new MyPermissionRequests();
            toSave.setId(mPRCreateRequest.getId());
            toSave.setPermitStartDate(mPRCreateRequest.getPermitStartDate());
            toSave.setPermitFinishDate(mPRCreateRequest.getPermitFinishDate());
            toSave.setApprovalStatus(mPRCreateRequest.getApprovalStatus());
            toSave.setPermissionRequestForm(permissionRequestForm);
            return mPRRepository.save(toSave);
        }
        else{
        return null;}
    }

    public MyPermissionRequests updateOneMyPermissionRequestsById(Long mPRId, MyPermissionRequestsUpdateRequest mPRUpdateRequest) {

        Optional<MyPermissionRequests> mPR = mPRRepository.findById(mPRId);
        if (mPR.isPresent()){
            MyPermissionRequests toUpdate = mPR.get();
            toUpdate.setPermitStartDate(mPRUpdateRequest.getPermitStartDate());
            toUpdate.setPermitFinishDate(mPRUpdateRequest.getPermitFinishDate());
            toUpdate.setNumberOfDaysOff(mPRUpdateRequest.getNumberOfDaysOff());
            mPRRepository.save(toUpdate);
            return toUpdate;
        }else{
            return null;}
        }

    public void deleteOneMyPermissionRequestsById(Long mPRId) {

        mPRRepository.deleteById(mPRId);
    }
}
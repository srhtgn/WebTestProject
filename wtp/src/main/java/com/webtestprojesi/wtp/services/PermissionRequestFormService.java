package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.Employee;
import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import com.webtestprojesi.wtp.repos.PermissionRequestsFormRepository;
import com.webtestprojesi.wtp.requests.PermissionRequestFormCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestFormUpdateRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionRequestFormService {
     private PermissionRequestsFormRepository pRFRepository;
     private EmployeeService empService;


    public PermissionRequestFormService(PermissionRequestsFormRepository pRFRepository, EmployeeService empService) {
        this.pRFRepository = pRFRepository;
        this.empService = empService;
    }

   public List<PermissionRequestForm> getAllPermissionRequestFormsById() {

        return pRFRepository.findAll();
    }

    public PermissionRequestForm getOnePermissionRequestFormById(Long pRFId) {
        return pRFRepository.findById(pRFId).orElse(null);
    }

    public PermissionRequestForm createOnePermissionRequestFormById(PermissionRequestFormCreateRequest pRFCreateRequest) {

        Employee employee = empService.getOneEmployeeById(pRFCreateRequest.getEmployeeId());
        if (employee == null){
            PermissionRequestForm toSave = new PermissionRequestForm();
            toSave.setId(pRFCreateRequest.getİd());
            toSave.setPermitStartDate(pRFCreateRequest.getPermitStartDate());
            toSave.setPermitFinishDate(pRFCreateRequest.getPermitFinishDate());
            toSave.setNumberOfDaysOff(pRFCreateRequest.getNumberOfDaysOff());
            toSave.setEmployee(employee);
            return pRFRepository.save(toSave);
        }else{
        return null;}
    }

    public PermissionRequestForm updateOnePermissionRequestFormById(Long pRFId, PermissionRequestFormUpdateRequest pRFUpdateRequest) {

        Optional<PermissionRequestForm> pRF = pRFRepository.findById(pRFId);
        if(pRF.isPresent()){
            PermissionRequestForm toUpdate = pRF.get();
            toUpdate.setPermitStartDate(pRFUpdateRequest.getPermitStartDate());
            toUpdate.setPermitFinishDate(pRFUpdateRequest.getPermitFinishDate());
            toUpdate.setNumberOfDaysOff(pRFUpdateRequest.getNumberOfDaysOff());
            return pRFRepository.save(toUpdate);
        }else{
        return null;}
    }

    public void deleteOnePermissionRequestFormById(Long pRFId) {

        pRFRepository.deleteById(pRFId);
    }

}

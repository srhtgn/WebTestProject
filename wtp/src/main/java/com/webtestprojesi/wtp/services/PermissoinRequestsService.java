package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.Employee;
import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import com.webtestprojesi.wtp.entities.PermissionRequests;
import com.webtestprojesi.wtp.repos.PermissionRequestsRepository;
import com.webtestprojesi.wtp.requests.PermissionRequestsCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestsUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissoinRequestsService {

    private final PermissionRequestsRepository pRRepository;

    private PermissionRequestFormService pRFService;

    private EmployeeService empService;

    public PermissoinRequestsService (PermissionRequestsRepository pRRepository){
        this.pRRepository = pRRepository;
        this.pRFService = pRFService;
        this.empService = empService;
    }

    public List<PermissionRequests> getAllPermissionRequestsWithParam(Optional<Long> permissionRequestFormId, Optional<Long> employeeId) {

        if(permissionRequestFormId.isPresent() && employeeId.isPresent()){

            return pRRepository.findByPermissionRequestFormIdAndEmployeeId(permissionRequestFormId, employeeId);
        }
        else if (permissionRequestFormId.isPresent()){
            return pRRepository.findByPermisssionRequestFormId(permissionRequestFormId);
        }
        else if (employeeId.isPresent()){
            return pRRepository.findByEmployeeId(employeeId);
        }
        else{
            return pRRepository.findAll();
        }
    }

    public PermissionRequests createOnePermissionRequestsById(PermissionRequestsCreateRequest pRCreateRequest) {

        PermissionRequestForm permissionRequestForm = pRFService.getOnePermissionRequestFormById(pRCreateRequest.getPermissionRequestFormId());
        Employee employee = empService.getOneEmployeeById(pRCreateRequest.getEmployeeId());

        if (permissionRequestForm != null && employee != null){
            PermissionRequests toSave = new PermissionRequests();
            toSave.setId(pRCreateRequest.getId());
            toSave.setPermissionRequestForm(permissionRequestForm);
            toSave.setEmployee(employee);
            return pRRepository.save(toSave);
        }else{
        return null;}
    }

    public PermissionRequests getOnePermissionRequestsById(Long pRId) {

        return pRRepository.findById(pRId).orElse(null);
    }

    public PermissionRequests updateOnePermissionRequestsById(Long pRId, PermissionRequestsUpdateRequest pRUpdateRequest) {

        Optional<PermissionRequests> pR = pRRepository.findById(pRId);
        if (pR.isPresent()){
            PermissionRequests toUpdate = pR.get();
            toUpdate.setPermissionRequestForm(new PermissionRequestForm());
            toUpdate.setEmployee(new Employee());
            pRRepository.save(toUpdate);
            return toUpdate;
        }else{
        return null;
        }
    }
}

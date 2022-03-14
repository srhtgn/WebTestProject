package com.webtestprojesi.wtp.services;

import com.webtestprojesi.wtp.entities.Employee;
import com.webtestprojesi.wtp.entities.PermissionRequestDetail;
import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import com.webtestprojesi.wtp.entities.PermissionRequests;
import com.webtestprojesi.wtp.repos.PermissionRequestDetailRepository;
import com.webtestprojesi.wtp.repos.PermissionRequestsRepository;
import com.webtestprojesi.wtp.requests.PermissionRequestDetailCreateRequest;
import com.webtestprojesi.wtp.requests.PermissionRequestDetailUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissoinRequestDetailService {

    private PermissionRequestDetailRepository pRDRepository;

    private PermissionRequestFormService pRFService;

    private EmployeeService empService;

    // Connecting to PermissionRequestFormService, EmployeeService and PermissionRequestDetailRepository
    public PermissoinRequestDetailService (PermissionRequestDetailRepository pRDRepository){
        this.pRDRepository = pRDRepository;
        this.pRFService = pRFService;
        this.empService = empService;
    }

    //Getting parameters by condition
    public List<PermissionRequestDetail> getAllPermissionRequestDetailWithParam(Optional<Long> permissionRequestFormId, Optional<Long> employeeId) {

        if(permissionRequestFormId.isPresent() && employeeId.isPresent()){

            return pRDRepository.findByPermissionRequestFormIdAndEmployeeId(permissionRequestFormId, employeeId);
        }
        else if (permissionRequestFormId.isPresent()){
            return pRDRepository.findByPermisssionRequestFormId(permissionRequestFormId);
        }
        else if (employeeId.isPresent()){
            return pRDRepository.findByEmployeeId(employeeId);
        }
        else{
            return pRDRepository.findAll();
        }
    }

    //Adding a new permission request to the PermissionRequestDetail
    public PermissionRequestDetail createOnePermissionRequestDetailById(PermissionRequestDetailCreateRequest pRDCreateRequest) {

        PermissionRequestForm permissionRequestForm = pRFService.getOnePermissionRequestFormById(pRDCreateRequest.getPermissionRequestFormId());
        Employee employee = empService.getOneEmployeeById(pRDCreateRequest.getEmployeeId());

        if (permissionRequestForm != null && employee != null){
            PermissionRequestDetail toSave;
            toSave = new PermissionRequestDetail();
            toSave.setId(pRDCreateRequest.getId());
            toSave.setPermitStartDate(pRDCreateRequest.getPermitStartDate());
            toSave.setPermitFinishDate(pRDCreateRequest.getPermitFinishDate());
            toSave.setApprovalStatus(pRDCreateRequest.getApprovalStatus());
            toSave.setNumberOfDaysOff(pRDCreateRequest.getNumberOfDaysOff());
            toSave.setPermissionRequestForm(permissionRequestForm);
            toSave.setEmployee(employee);
            return pRDRepository.save(toSave);
        }else{
            return null;}
    }

    //Retrieve records from repository
    public PermissionRequestDetail getOnePermissionRequestDetailById(Long pRDId) {

        return pRDRepository.findById(pRDId).orElse(null);
    }

    //Update records in the repository
    public PermissionRequestDetail updateOnePermissionRequestDetailById(Long pRDId, PermissionRequestDetailUpdateRequest pRDUpdateRequest) {

        Optional<PermissionRequestDetail> pRD = pRDRepository.findById(pRDId);
        if (pRD.isPresent()){
            PermissionRequestDetail toUpdate = null;
            pRD.get();
            toUpdate.setPermitStartDate(pRDUpdateRequest.getPermitStartDate());
            toUpdate.setPermitFinishDate(pRDUpdateRequest.getPermitFinishDate());
            toUpdate.setApprovalStatus(pRDUpdateRequest.getApprovalStatus());
            toUpdate.setNumberOfDaysOff(pRDUpdateRequest.getNumberOfDaysOff());
            toUpdate.setPermissionRequestForm(new PermissionRequestForm());
            toUpdate.setEmployee(new Employee());
            return pRDRepository.save(toUpdate);
        }else{
            return null;}
    }

    //Delete records in the repository
    public void deleteOnePermissionRequestDetailById(Long pRDId) {
        pRDRepository.deleteById(pRDId);
    }
}

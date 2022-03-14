package com.webtestprojesi.wtp.repos;

import com.webtestprojesi.wtp.entities.PermissionRequestDetail;
import com.webtestprojesi.wtp.entities.PermissionRequests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRequestDetailRepository extends JpaRepository<PermissionRequests, Long> {

    List<PermissionRequestDetail> findByPermissionRequestFormIdAndEmployeeId(Optional<Long> permissionRequestFormId, Optional<Long> employeeId);

    List<PermissionRequestDetail> findByPermisssionRequestFormId(Optional<Long> permissionRequestFormId);

    List<PermissionRequestDetail> findByEmployeeId(Optional<Long> employeeId);
}

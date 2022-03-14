package com.webtestprojesi.wtp.repos;

import com.webtestprojesi.wtp.entities.MyPermissionRequests;
import com.webtestprojesi.wtp.entities.PermissionRequests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRequestsRepository extends JpaRepository<PermissionRequests, Long> {
    List<PermissionRequests> findByPermissionRequestFormIdAndEmployeeId(Optional<Long> permissionRequestFormId, Optional<Long> employeeId);

    List<PermissionRequests> findByPermisssionRequestFormId(Optional<Long> permissionRequestFormId);

    List<PermissionRequests> findByEmployeeId(Optional<Long> employeeId);
}

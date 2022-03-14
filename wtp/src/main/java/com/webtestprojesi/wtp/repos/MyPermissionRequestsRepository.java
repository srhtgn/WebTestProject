package com.webtestprojesi.wtp.repos;


import com.webtestprojesi.wtp.entities.MyPermissionRequests;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyPermissionRequestsRepository extends JpaRepository<MyPermissionRequests, Long> {
    List<MyPermissionRequests> findByPermisssionRequestFormId(Optional<Long> permissionRequestFormId);

}

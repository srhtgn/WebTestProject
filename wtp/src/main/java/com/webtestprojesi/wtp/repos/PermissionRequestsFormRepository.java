package com.webtestprojesi.wtp.repos;

import com.webtestprojesi.wtp.entities.PermissionRequestForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRequestsFormRepository extends JpaRepository<PermissionRequestForm, Long>{
}

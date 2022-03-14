package com.webtestprojesi.wtp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webtestprojesi.wtp.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}

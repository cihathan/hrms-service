package com.hrms.hrmsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hrmsservice.entities.Cvs;

@Repository
public interface CvsRepository extends JpaRepository<Cvs, Long> {

}

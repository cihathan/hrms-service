package com.hrms.hrmsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hrmsservice.entities.EducationInfo;

@Repository
public interface EducationInfoRepository extends JpaRepository<EducationInfo, Long> {

	List<EducationInfo> getEducationInfoBycvId(Long cvId);
	void deleteByCvId(Long cvId);
}

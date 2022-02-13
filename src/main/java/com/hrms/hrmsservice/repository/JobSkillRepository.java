package com.hrms.hrmsservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hrmsservice.entities.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, Long> {

	List<JobSkill> getJobSkillBycvId(Long cvId);
	void deleteByCvId(Long cvId);
}

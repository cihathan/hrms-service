package com.hrms.hrmsservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hrms.hrmsservice.entities.dto.UserDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cvs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cvs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String address;

	private Long userId;

	@Transient
	private List<EducationInfo> educationInfos;

	@Transient
	private List<JobExperience> jobExperiences;

	@Transient
	private List<JobSkill> jobSkills;
	


}

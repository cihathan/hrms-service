package com.hrms.hrmsservice.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvsDto {

	private String address;
	private String education;
	private String educationPeriod;
	private String workPlace;
	private String yearsOfExperience;
	private String jobDescription;
	private String jobSkill;
}

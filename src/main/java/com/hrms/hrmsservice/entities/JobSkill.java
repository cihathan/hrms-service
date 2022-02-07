package com.hrms.hrmsservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_skills")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long cvId;
	private String jobSkill;
}

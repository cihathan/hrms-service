package com.hrms.hrmsservice.service;

import org.springframework.stereotype.Service;

import com.hrms.hrmsservice.entities.Cvs;
import com.hrms.hrmsservice.entities.EducationInfo;
import com.hrms.hrmsservice.repository.CvsRepository;
import com.hrms.hrmsservice.repository.EducationInfoRepository;
import com.hrms.hrmsservice.repository.JobExperienceRepository;
import com.hrms.hrmsservice.repository.JobSkillRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvsService {
	private final CvsRepository cvsRepository;
	private final EducationInfoRepository educationInfoRepository;
	private final JobExperienceRepository jobExperienceRepository;
	private final JobSkillRepository jobSkillRepository;

	public Cvs saveCv(Cvs cv) {

		Cvs savedCv = cvsRepository.save(cv);
		for (EducationInfo educationInfo : cv.getEducationInfos()) {
			educationInfo.setCvId(savedCv.getId());
			educationInfoRepository.save(educationInfo);
		}

		savedCv.setEducationInfos(educationInfoRepository.getEducationInfoBycvId(savedCv.getId()));

		return savedCv;
	}
	
	

}

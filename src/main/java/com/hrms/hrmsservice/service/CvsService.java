package com.hrms.hrmsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hrms.hrmsservice.entities.Cvs;
import com.hrms.hrmsservice.entities.EducationInfo;
import com.hrms.hrmsservice.entities.JobExperience;
import com.hrms.hrmsservice.entities.JobSkill;
import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.entities.dto.UserDto;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.repository.CvsRepository;
import com.hrms.hrmsservice.repository.EducationInfoRepository;
import com.hrms.hrmsservice.repository.JobExperienceRepository;
import com.hrms.hrmsservice.repository.JobSkillRepository;
import com.hrms.hrmsservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CvsService {

	private final CvsRepository cvsRepository;
	private final EducationInfoRepository educationInfoRepository;
	private final JobExperienceRepository jobExperienceRepository;
	private final JobSkillRepository jobSkillRepository;
	private final UserRepository userRepository;

	public Cvs saveCv(Cvs cv) throws ValidationException {
		Optional<Users> user = userRepository.findById(cv.getUserId());
		if (!user.isPresent()) {
			throw new ValidationException("Kullanıcı Bulunamadı");
		}
		Cvs savedCv = cvsRepository.save(cv);
		for (EducationInfo educationInfo : cv.getEducationInfos()) {
			educationInfo.setCvId(savedCv.getId());
			educationInfoRepository.save(educationInfo);
		}
		for (JobExperience jobExperience : cv.getJobExperiences()) {
			jobExperience.setCvId(savedCv.getId());
			jobExperienceRepository.save(jobExperience);
		}
		for (JobSkill jobSkill : cv.getJobSkills()) {
			jobSkill.setCvId(savedCv.getId());
			jobSkillRepository.save(jobSkill);
		}
		getSkills(savedCv);
		return savedCv;
	}

	public Cvs updateCv(Cvs newCv) throws ValidationException {
		Optional<Cvs> cv = cvsRepository.findById(newCv.getId());
		if (cv.isPresent()) {						
			return saveCv(newCv);
		} else {
			throw new ValidationException("Böyle bir Cv bulunamadı!");
		}
	}

	/*
	 * public Cvs updateCv(Long cvId, Cvs cvs) { Optional<Cvs> cv =
	 * cvsRepository.findById(cvId); if(cv.isPresent()) { Cvs toUpdate = cv.get();
	 * toUpdate.setAddress(cvs.getAddress()); toUpdate.);
	 * 
	 * }
	 * 
	 * return null; }
	 */
	private Users checkUser(Users users) throws ValidationException {
		Optional<Users> userOpt = userRepository.findById(users.getId());
		if (!userOpt.isPresent()) {
			throw new ValidationException("Kullanıcı Bulunamadı");
		}
		if (!userOpt.get().getPassword().equals(users.getPassword())) {			
			throw new ValidationException("Kullanıcı Paralosu Doğru Değil");			
		}
		return userOpt.get();
	}

	public List<Cvs> getAllCvs(Users users) throws ValidationException {
		Users user = checkUser(users);
		if (!user.getAuthLevel().equals(1)) {
			throw new ValidationException("Bütün cv lri sorgulamak için yetkili değilsin");			
		}
		List<Cvs> returnedCv = cvsRepository.findAll();
		for (Cvs cvs : returnedCv) {
			getSkills(cvs);
		}
		return returnedCv;
	}
	


	public Cvs getCv(Users users) throws ValidationException {
		checkUser(users);
		return getSkills(cvsRepository.findByUserId(users.getId()));
	}
	
	private Cvs getSkills(Cvs cvs) {
		cvs.setEducationInfos(educationInfoRepository.getEducationInfoBycvId(cvs.getId()));
		cvs.setJobExperiences(jobExperienceRepository.getJobExperienceBycvId(cvs.getId()));
		cvs.setJobSkills(jobSkillRepository.getJobSkillBycvId(cvs.getId()));
		return cvs;
	}

	public void deleteCvById(Long cvId) {
		jobExperienceRepository.deleteByCvId(cvId);
		educationInfoRepository.deleteByCvId(cvId);
		jobExperienceRepository.deleteByCvId(cvId);
		cvsRepository.deleteById(cvId);
	}


}

package com.hrms.hrmsservice.api;

import com.hrms.hrmsservice.entities.Cvs;
import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.service.CvsService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/api/cv")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CvApi {

	private final CvsService cvsService;

	@PostMapping("/saveCv")
	public Cvs savedCv(@RequestBody Cvs cv) throws ValidationException {
		return cvsService.saveCv(cv);
	}

	@PutMapping("/updateCv")
	public Cvs updateCv(@RequestBody Cvs cv) throws ValidationException {
		return cvsService.updateCv(cv);
	}

	@PostMapping("/getAllCvs")
	public List<Cvs> getAllCvs(@RequestBody Users users) throws ValidationException {
		return cvsService.getAllCvs(users);
	}
	
	@PostMapping("/getCv")
	public Cvs getCv(@RequestBody Users users) throws ValidationException {
		return cvsService.getCv(users);
	}

	@DeleteMapping("/deleteCv/{cvId}")
	public void deleteCvById(@PathVariable Long cvId) {
		cvsService.deleteCvById(cvId);
	}


}

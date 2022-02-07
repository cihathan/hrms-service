package com.hrms.hrmsservice.api;

import com.hrms.hrmsservice.entities.Cvs;
import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.entities.dto.UserDto;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.service.CvsService;
import com.hrms.hrmsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/cv")
@RequiredArgsConstructor
public class CvApi {

    private final CvsService cvsService;


    @PostMapping("/save")
    public Cvs savedCv(@RequestBody Cvs cv) throws ValidationException {
        return cvsService.saveCv(cv);
    }

//    @GetMapping("/getUser")
//    public UserDto getUserById(@RequestParam Long id){
//        return userService.getUserById(id);
//    }
//
//    @GetMapping("/getUserByName")
//    public List<Users> getUserByName(@RequestParam String name){
//        return userService.getUserByName(name);
//    }
}

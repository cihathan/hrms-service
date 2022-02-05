package com.hrms.hrmsservice.api;

import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.entities.dto.UserDto;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;


    @PostMapping("/save")
    public UserDto saveUser(@RequestBody Users user) throws ValidationException {
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public UserDto getUserById(@RequestParam Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/getUserByName")
    public List<Users> getUserByName(@RequestParam String name){
        return userService.getUserByName(name);
    }
}

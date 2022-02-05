package com.hrms.hrmsservice.service;

import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.entities.dto.UserDto;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMap;

    public UserDto saveUser(Users user) throws ValidationException {
        if (user.getName() == null || user.getName().length()==0){
            throw new ValidationException("Kullanıcı adı boş Geçemez");
        }
        user.setAuthLevel(0);
        Users savedUser = userRepository.save(user);

        UserDto userdto = new UserDto();
        userdto.setId(savedUser.getId());
        userdto.setName(savedUser.getName());

        return userdto;
    }

    public UserDto getUserById(Long id) {
        Users user = userRepository.getById(id);
        UserDto userDto = modelMap.map(user, UserDto.class);
        return userDto;
    }

    public List<Users> getUserByName(String name) {
        return userRepository.userlarinAdiniCek(name);
    }
}

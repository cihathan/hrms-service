package com.hrms.hrmsservice.service;

import com.hrms.hrmsservice.entities.Users;
import com.hrms.hrmsservice.entities.dto.UserDto;
import com.hrms.hrmsservice.exceptions.ValidationException;
import com.hrms.hrmsservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	public UserDto saveUser(Users user) throws ValidationException {
		if (user.getFirstName() == null || user.getFirstName().length() < 3) {
			throw new ValidationException("İsim alanı 3 karakterden kısa veya boş olamaz!");
		}
		if (user.getLastName() == null || user.getLastName().length() < 3) {
			throw new ValidationException("Soyad alanı alanı 3 karakterden kısa veya boş olamaz!");
		}
		if (user.getPassword() == null || user.getPassword().length() < 8) {
			throw new ValidationException("Şifre alanı 8 karakterden daha kısa olamaz!");
		}
		if (user.getEmail() == null) {
			throw new ValidationException("E-mail alanı boş bırakılamaz!");
		}

		user.setAuthLevel(0);
		Users savedUser = userRepository.save(user);
		
		UserDto userdto = new UserDto();
		userdto.setFirstName(savedUser.getFirstName());
		userdto.setLastName(savedUser.getLastName());
		userdto.setEmail(savedUser.getEmail());
		userdto.setAuthLevel(savedUser.getAuthLevel());

		return userdto;
	}

	public UserDto getUserById(Long id) {
		Users user = userRepository.getById(id);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	public List<Users> getUserByName(String name) {
		return userRepository.getUsersByFirstName(name);
	}

	public Users updateOneUser(Users newUser) throws ValidationException {
		Optional<Users> user = userRepository.findById(newUser.getId());
		if (user.isPresent()) {
			Users foundUser = user.get();
			foundUser.setFirstName(newUser.getFirstName());
			foundUser.setLastName(newUser.getLastName());
			foundUser.setEmail(newUser.getEmail());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		} else {
			throw new ValidationException("Böyle bir kullanıcı bulunamadı!");
		}

	}

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUserById(Long userId) {
		userRepository.deleteById(userId);
	}

}

package com.hrms.hrmsservice.repository;

import com.hrms.hrmsservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.firstName = ?1")
	public List<Users> getUsersByName(String name);

	List<Users> getUsersByFirstName(String name);

}

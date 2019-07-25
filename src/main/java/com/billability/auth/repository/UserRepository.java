package com.billability.auth.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.billability.auth.model.UserDAO;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<UserDAO, Long> {
		
	public static final String ALL_USERS = "SELECT u.id,first_name,last_name,email,role_name FROM users u LEFT JOIN roles r ON u.role_id = r.id ORDER BY u.created_at DESC";
	//public static final String ALL_USERS = "SELECT * FROM users";
	@Query(value = ALL_USERS, nativeQuery = true)
	public ArrayList userList();
	
	public UserDAO findById(int id);
	
}


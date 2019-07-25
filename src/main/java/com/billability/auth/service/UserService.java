package com.billability.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billability.auth.model.UserDAO;
import com.billability.auth.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
    @Autowired
    public UserService(UserRepository userRepository) { 
      this.userRepository = userRepository;
    }
    
    public ArrayList userList() {
    	return userRepository.userList();
    }
	
	public void saveUser(UserDAO userDAO) {
		userRepository.save(userDAO);
	}
	
	public UserDAO getUserById(int id) {
    	return userRepository.findById(id);
    }
	
	public void deleteUser(UserDAO userDAO) {
		userRepository.delete(userDAO);
	}

}

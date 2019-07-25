package com.billability.auth.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.billability.auth.model.UserValidate;
import com.billability.auth.model.UserDAO;
import com.billability.auth.service.UserService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.validation.BindingResult;
//import java.util.ArrayList;

@Controller
public class UsersController {
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;
	
	@Autowired
    //public UsersController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
	public UsersController(UserService userService) {	
      
      //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
      this.userService = userService;
    }

    @GetMapping("/users-list")
    public String usersList(Model model) {
    	//ArrayList usersList =  userService.userList();
    	model.addAttribute("users", userService.userList());
    	//System.out.println(bindingResult.getAllErrors());
    	//System.out.println("BEFORE TEST"+userService.userList().get(0));
        return "users_list"; //view
    }
    
    @GetMapping("/user-add")
    public String userAdd(UserValidate userValidate) {
        
        return "users_add"; //view
    }
    
    @PostMapping("/user-register")
    public String checkUserInfo(@Valid UserValidate userValidate, BindingResult bindingResult, UserDAO userDAO) {

        if (bindingResult.hasErrors()) {
        	
        	//System.out.println(bindingResult.getAllErrors());
            //System.exit(0);//return "form";
            return "users_add"; //view
        }
        //System.out.println(user.toString());
        //System.exit(0);
        userService.saveUser(userDAO);
        //return "users_list";
        return "redirect:/users-list";
    }
    
    @GetMapping("/user-edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
    	//userService.getUserById(id); 
    	//UserDAO user = userService.getUserById(id);
    	//System.out.println("BEFORE TEST"+userService.getUserById(id).toString());
        model.addAttribute("user", userService.getUserById(id));
        
        return "users_edit";
    }
    
 
    @PostMapping("/user-update/{id}")
    public String updateUserInfo(@PathVariable("id") int id, Model model, UserDAO userDAO, @Valid UserValidate userValidate, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        	
        	//System.out.println("All edit errors: "+bindingResult.getAllErrors());
            //System.exit(0);//return "form";
        	model.addAttribute("user", userService.getUserById(id));
            return "users_edit"; //view
        }
        //System.out.println(user.toString());
        //System.exit(0);
        userService.saveUser(userDAO);
        //return "users_list";
        return "redirect:/users-list";
    }
    
    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id, UserDAO userDAO) {
        //User user = userRepository.findById(id)
        //  .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	userService.deleteUser(userDAO);
        //userRepository.delete(user);
    	return "redirect:/users-list";
    	//model.addAttribute("users", userRepository.findAll());
        //return "index";
    }

}
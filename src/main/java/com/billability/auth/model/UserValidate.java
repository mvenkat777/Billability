package com.billability.auth.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserValidate {
	
    @NotBlank(message="First Name is mandatory")
    @Size(max=50,message="First Name cannot exceed more than 50 characters")
    private String firstname;
	
    @NotBlank(message="Last Name is mandatory")
    @Size(max=50,message="Last Name cannot exceed more than 50 characters")
    private String lastname;
    
    @NotBlank(message="Email is mandatory")
    @Email(message="Enter valid email address")
    private String email;
    
    @NotBlank(message="Password is mandatory")
    private String password;
    
    @NotBlank(message="Re-type your password as its mandatory")
    private String confirmpassword;
    
    @NotNull(message="Select your role as its mandatory")
    private Integer role;
    
	@Override
	public String toString() {
		return "UserValidate [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", role=" + role + "]";
	}
		
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}

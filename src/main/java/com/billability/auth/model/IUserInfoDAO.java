package com.billability.auth.model;

import com.billability.auth.model.UserDAO;

public interface IUserInfoDAO {
	UserDAO getActiveUser(String userName);
} 

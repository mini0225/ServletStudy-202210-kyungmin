package com.study.service;

import java.util.ArrayList;
import java.util.List;

import com.study.domain.User;
import com.study.repository.UserRepository;

public class AccountService {

	private static AccountService instance = null;
	
	private AccountService () {}
	
	public static AccountService getInstance() {
		
		if(instance == null) {
			instance = new AccountService();
		}
		return instance;
	}
	
	public boolean isduplicateUsername(String username) {
				
		User user = UserRepository.getInstance().findUserByUsername(username);
		return user != null;
	}
	
	public void register(User user) {
		UserRepository.getInstance().saveUser(user);
	}
	
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	
	public boolean checkPassword(User user, String password) {
		return user.getPassword().equals(password);
	}

}

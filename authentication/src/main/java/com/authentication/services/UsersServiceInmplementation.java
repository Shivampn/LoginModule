package com.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.entities.Users;
import com.authentication.repository.UsersRepository;

@Service
public class UsersServiceInmplementation implements UsersService {

	@Autowired
	UsersRepository repo;
	@Override
	public void addUser(Users user) {
		repo.save(user);
	}
	@Override
	public Users getUserByName(String username) {
	return repo.findByUsername(username);
	}
	@Override
	public boolean usernameExist(String username) {
		Users user=repo.findByUsername(username);
		if(user != null )
			return true;
		else 
			return false;
	}
	

}

package com.authentication.services;

import com.authentication.entities.Users;

public interface UsersService {
void addUser(Users user);
Users getUserByName(String username);
boolean usernameExist(String username);
}

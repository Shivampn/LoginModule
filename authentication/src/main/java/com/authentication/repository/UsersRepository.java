package com.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
Users findByUsername(String name);
}

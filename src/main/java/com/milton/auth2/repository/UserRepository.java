package com.milton.auth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.auth2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserName(String userName);
}

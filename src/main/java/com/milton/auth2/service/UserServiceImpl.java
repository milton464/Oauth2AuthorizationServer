package com.milton.auth2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.milton.auth2.model.User;
import com.milton.auth2.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;


	@Override
	public void save(User user) {
		log.info("saving user");
		userRepo.save(user);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Optional<User> update(int userId, User user) {
		return userRepo.findById(userId);

	}

	@Override
	public void delete(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public Optional<User> getUserById(int userId) {
		return userRepo.findById(userId);

	}

	@Override
	public User getUserByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

}

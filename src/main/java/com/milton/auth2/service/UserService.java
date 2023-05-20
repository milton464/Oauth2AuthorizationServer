package com.milton.auth2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.milton.auth2.model.User;

@Service
public interface UserService {

	public void save(User user);

	public Optional<User> update(int userId, User user);

	public void delete(int userId);

	public List<User> getUsers();

	public Optional<User> getUserById(int userId);

	public User getUserByUserName(String userName);
}

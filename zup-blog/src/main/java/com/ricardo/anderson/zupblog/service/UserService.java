package com.ricardo.anderson.zupblog.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.anderson.zupblog.entity.User;
import com.ricardo.anderson.zupblog.repository.UserRepository;

@Service
public class UserService {

	public UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void delUser(Long id) {
		userRepository.deleteById(id);
	}
	public User putUser(Long id, User userBody) {
		User userBd  = userRepository.findById(id).get();
		BeanUtils.copyProperties(userBody, userBd, "id");
		return this.saveUser(userBd);
	}
}

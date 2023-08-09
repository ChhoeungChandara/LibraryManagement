package com.chandara.libraryManagement.Service.Impl;

import org.springframework.stereotype.Service;

import com.chandara.libraryManagement.Entity.User;
import com.chandara.libraryManagement.Exception.ResourceNotFoundException;
import com.chandara.libraryManagement.Repository.UserRepository;
import com.chandara.libraryManagement.Service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserId(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user", id));
	}

	@Override
	public User update(Long id, User user) {
		User userId = getUserId(id);
		userId.setName(user.getName());
		userId.setAddress(user.getAddress());
		return userRepository.save(userId);
	}

	@Override
	public void delete(Long id) {
		User userId = getUserId(id);
		userRepository.delete(userId);
	}

}

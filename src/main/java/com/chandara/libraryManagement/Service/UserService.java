package com.chandara.libraryManagement.Service;

import java.util.List;

import com.chandara.libraryManagement.Entity.User;

public interface UserService {
	User create(User user);
	User getUserId(Long id);
	User update(Long id,User user);
	void delete(Long id);
	List<User> findUserByname(String name);
	List<User> getAll();

}

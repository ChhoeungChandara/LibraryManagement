package com.chandara.libraryManagement.Service;

import com.chandara.libraryManagement.Entity.User;

public interface UserService {
	User create(User user);
	User getUserId(Long id);
	User update(Long id,User user);
	void delete(Long id);

}

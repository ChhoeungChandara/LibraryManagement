package com.chandara.libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandara.libraryManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}

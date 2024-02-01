package com.chandara.libraryManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.chandara.libraryManagement.Entity.User;
import com.chandara.libraryManagement.dto.UserDTO;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	User toUser(UserDTO dto);
}

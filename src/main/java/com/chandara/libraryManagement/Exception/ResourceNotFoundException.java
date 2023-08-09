package com.chandara.libraryManagement.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiExceptioin{

	public ResourceNotFoundException(String resourceName,Long id) {
		super(HttpStatus.NOT_FOUND,String.format("%s with id = %d not found",resourceName,id));
	}
	

}

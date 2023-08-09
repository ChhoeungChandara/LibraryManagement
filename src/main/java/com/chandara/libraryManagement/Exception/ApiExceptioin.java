package com.chandara.libraryManagement.Exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiExceptioin extends RuntimeException{
	
	private final  HttpStatus httpStatus;
	private final String message;
	

}

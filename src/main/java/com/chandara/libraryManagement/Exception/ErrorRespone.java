package com.chandara.libraryManagement.Exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ErrorRespone {
	private HttpStatus httpStatus;
	private String name;

}

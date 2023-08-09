package com.chandara.libraryManagement.Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(ApiExceptioin.class)
	public ResponseEntity<?> HandleApiException(ApiExceptioin e){
		ErrorRespone errorRespone = new ErrorRespone(e.getHttpStatus(),e.getMessage());
		return ResponseEntity.status(e.getHttpStatus()).body(errorRespone);
	}

}

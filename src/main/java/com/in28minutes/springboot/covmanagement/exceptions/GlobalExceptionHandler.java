package com.in28minutes.springboot.covmanagement.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.in28minutes.springboot.covmanagement.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(Exception exception , WebRequest request ){
		ErrorResponseDTO errorDto = new ErrorResponseDTO(request.getDescription(false), HttpStatus.NOT_FOUND, exception.getMessage() , LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponseDTO>(errorDto, HttpStatus.NOT_FOUND);
		
	}
}

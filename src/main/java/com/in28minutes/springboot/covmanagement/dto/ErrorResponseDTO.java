package com.in28minutes.springboot.covmanagement.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {

	private String apiPath;
	
	private HttpStatus statusCode;
	
	private String errorMessage;
	
	private LocalDateTime errorTime;
}

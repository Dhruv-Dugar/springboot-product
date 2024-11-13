package com.Product.productApplication.Error;

import com.Product.productApplication.Model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ProductNotFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
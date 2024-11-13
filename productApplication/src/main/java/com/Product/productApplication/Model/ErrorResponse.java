package com.Product.productApplication.Model;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ErrorResponse {
	//
	private LocalDateTime timestamp;
	private int status;   //404,401,200
	private String error;
	private String message;
	private String path;  // /api/employees/id

	public ErrorResponse(HttpStatus status, String message, String path) {
		this.timestamp = LocalDateTime.now();
		this.status = status.value();
		this.error = status.getReasonPhrase();
		this.message = message;
		this.path = path;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
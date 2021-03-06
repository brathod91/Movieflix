package io.bkr.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class DataAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 405802649322364762L;

	public DataAlreadyExistsException(String message) {
		super(message);
	}

	public DataAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}

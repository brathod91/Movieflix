package io.bkr.movieflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {
	private static final long serialVersionUID = 405802649322364762L;

	public NoDataFoundException(String message) {
		super(message);
	}

	public NoDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

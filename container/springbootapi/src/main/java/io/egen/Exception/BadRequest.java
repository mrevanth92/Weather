package io.egen.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

	private static final long serialVersionUID = 3448570458524977900L;

	public BadRequest(String message){
		super(message);
	}
	
	public BadRequest(String message,Throwable cause){
		super(message,cause);
	}
}

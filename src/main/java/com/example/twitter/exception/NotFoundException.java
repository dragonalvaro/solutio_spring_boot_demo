package com.example.twitter.exception;

public class NotFoundException extends RuntimeException {

	private static final String DEFAULT_MESSAGE = "Resource not found";

	private static final long serialVersionUID = -8279681828323552487L;

	public NotFoundException(String cause) {
		super(cause);
	}

	public NotFoundException() {
		super(DEFAULT_MESSAGE);
	}

}

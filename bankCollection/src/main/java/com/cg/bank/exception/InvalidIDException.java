package com.cg.bank.exception;

public class InvalidIDException extends Exception {
	public InvalidIDException() {
		System.err.println("Invalid Credentials");
	}

}

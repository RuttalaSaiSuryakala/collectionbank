package com.cg.bank.exception;

public class TransactionException extends Exception {
	public TransactionException() {
		System.err.println("Fund Transfer failed");
	}

}

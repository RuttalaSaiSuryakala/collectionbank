package com.cg.bank.customer;

public class Transaction {
	private long transactionId,fromAccountNo,toAccountNo,amountTransferred;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public long getAmountTransferred() {
		return amountTransferred;
	}

	public void setAmountTransferred(long amountTransferred) {
		this.amountTransferred = amountTransferred;
	}

}

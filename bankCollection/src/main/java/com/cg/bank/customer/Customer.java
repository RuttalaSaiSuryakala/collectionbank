package com.cg.bank.customer;

public class Customer {

	private long accountNo;
	private long balance;
	private String firstName,lastName,emailId,password,pancardNo,address,aadhaarNo,mobileNo;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public long getAccountNo() {
		return accountNo;
	}
	public Customer(long accountNo, long balance, String firstName, String lastName, String emailId, String password,
			String pancardNo, String address, String aadhaarNo, String mobileNo) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.pancardNo = pancardNo;
		this.address = address;
		this.aadhaarNo = aadhaarNo;
		this.mobileNo = mobileNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}

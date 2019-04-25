package com.cg.bank.custservice;

import com.cg.bank.custdao.CustDAO;
import com.cg.bank.custdao.CustDAOImpl;
import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;

public class CustServiceImpl implements CustService {

	CustDAO custdao = new CustDAOImpl();
	Customer customer = new Customer();
	
	boolean validateUserInput(Customer customer) {
		boolean b=false;
		if (customer.getMobileNo().length() == 10) {
			if (customer.getAadhaarNo().length() == 12) {
				b=true;
			} else
				b=false;
		} else
			b=false;
		
		return b;
		
	}

	public Customer register(Customer customer) {
		boolean b= validateUserInput(customer);
		if(b) {
			customer = custdao.register(customer);
			return customer;
		}
		else
			return null;

	}

	public Customer login(long acc, String pswd) {
		customer = custdao.login(acc, pswd);
		return customer;

	}

	public Transaction fundTransfer(Transaction transaction) {
		transaction=custdao.fundTransfer(transaction);
		return transaction;
	}

}

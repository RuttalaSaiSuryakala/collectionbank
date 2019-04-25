package com.cg.bank.custservice;

import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;



public interface CustService {
	Customer register(Customer customer);
	Customer login(long acc, String pswd);
	Transaction fundTransfer(Transaction transaction);

}

package com.cg.bank.custdao;

import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;

public interface CustDAO {
	Customer register(Customer customer);
	Customer login(long acc,String pswd);
	Transaction fundTransfer(Transaction transaction);

}

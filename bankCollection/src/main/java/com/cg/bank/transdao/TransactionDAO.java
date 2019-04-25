package com.cg.bank.transdao;

import com.cg.bank.customer.Customer;

public interface TransactionDAO {

	long deposit(Customer customer,long amt);
	long withdrawl(Customer customer,long amt);
	long showBal(Customer customer,long amt);

}

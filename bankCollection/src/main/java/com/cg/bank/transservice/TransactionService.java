package com.cg.bank.transservice;

import com.cg.bank.customer.Customer;

public interface TransactionService {

	long deposit(Customer customer,long amt);

	long withdrawl(Customer customer,long amt);

	long dispBal(Customer customer,long amt);

}

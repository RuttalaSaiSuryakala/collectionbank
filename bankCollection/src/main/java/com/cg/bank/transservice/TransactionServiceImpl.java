package com.cg.bank.transservice;

import com.cg.bank.customer.Customer;
import com.cg.bank.transdao.TransDAOImpl;
import com.cg.bank.transdao.TransactionDAO;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDAO transactionDAO=new TransDAOImpl();

	public long deposit(Customer customer,long amt) {
		long res=transactionDAO.deposit(customer,amt);
		return res;
	}

	public long withdrawl(Customer customer,long amt) {
		long res=transactionDAO.withdrawl(customer,amt);
		return res;
	}

	public long dispBal(Customer customer,long amt) {
		long res=transactionDAO.showBal(customer,amt);
		return res;
		
	}

}

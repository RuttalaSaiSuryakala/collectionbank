package com.cg.bank.custdao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;

public class CustDAOImpl implements CustDAO {
	Customer customer = new Customer();
	Customer customer1 = new Customer();
	Customer customer2 = new Customer();
	Random random = new Random();
	long accountNo = 1;
	//accountNo = 1 + new Random().nextInt(10000);
	
	Map<Long, Customer> CustomerEntry = new HashMap<Long, Customer>();

	public Customer register(Customer customer) {
		customer.setAccountNo(accountNo + CustomerEntry.size());
		accountNo = customer.getAccountNo();
		CustomerEntry.put((long) accountNo,
				new Customer(accountNo, customer.getBalance(), customer.getFirstName(), customer.getLastName(),
						customer.getEmailId(), customer.getPassword(), customer.getPancardNo(), customer.getAddress(),
						customer.getAadhaarNo(), customer.getMobileNo()));

		return customer;
	}

	public Customer login(long acc, String pswd) {
		int c = 0;
		for (Map.Entry<Long, Customer> m : CustomerEntry.entrySet()) {
			if (m.getKey().equals(acc)) {
				customer1 = m.getValue();
				if (pswd.equals(customer1.getPassword()))
					c++;
			}
		}

		if (c != 0)
			return customer1;
		else
			return null;

	}

	public Transaction fundTransfer(Transaction transaction) {
		long amt = transaction.getAmountTransferred();
		long transactionId = 100 + new Random().nextInt(10000);

		for (Map.Entry<Long, Customer> me : CustomerEntry.entrySet()) {
			if (me.getKey().equals(transaction.getFromAccountNo())) {
				customer1 = (Customer) me.getValue();
				transaction.setFromAccountNo(customer1.getAccountNo());
			}
		}
		if (customer1.getBalance() < amt) {
			return null;
		} else {
			customer1.setBalance(customer1.getBalance() - amt);
			CustomerEntry.replace(transaction.getFromAccountNo(), customer1);
			for (Map.Entry<Long, Customer> m : CustomerEntry.entrySet()) {
				if (m.getKey().equals(transaction.getToAccountNo())) {
					customer2 = m.getValue();
					customer2.setBalance(customer2.getBalance() + amt);
					CustomerEntry.replace(customer2.getAccountNo(), customer2);
					transaction.setAmountTransferred(amt);
					transaction.setTransactionId(transactionId);
					transaction.setToAccountNo(customer2.getAccountNo());

				}
			}
			return transaction;
		}

	}
}
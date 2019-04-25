package com.cg.bankCollection;

import java.util.Scanner;

import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;
import com.cg.bank.custservice.CustService;
import com.cg.bank.custservice.CustServiceImpl;
import com.cg.bank.exception.InvalidIDException;
import com.cg.bank.exception.InvalidInputException;
import com.cg.bank.exception.TransactionException;
import com.cg.bank.exception.WithDrawlException;
import com.cg.bank.transservice.TransactionService;
import com.cg.bank.transservice.TransactionServiceImpl;

public class App {
	static Transaction transaction = new Transaction();
	static CustService custservice = new CustServiceImpl();
	static TransactionService transactionservice = new TransactionServiceImpl();

	public static Scanner sc = new Scanner(System.in);

	public void disp(Customer customer) {
		TransactionService transactionService = new TransactionServiceImpl();
	long amt = 0, res = 0;
		System.out.println("Select option 1. deposit 2. withdrawl 3. show balance 4. Fund Transfer");
		int i = sc.nextInt();
		switch (i) {
		case 1:
			System.out.println("Enter amount to deposit");
			amt = sc.nextLong();
			res = transactionService.deposit(customer,amt);
			System.out.println("Balance is" + res);
			break;
		case 2:
			System.out.println("Enter amount to be withdrawn");
			amt = sc.nextLong();
			res = transactionService.withdrawl(customer,amt);
			if (res != 0)
				System.out.println("Balance is" + res);
			else
				try {
					throw new WithDrawlException();
				} catch (WithDrawlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
		case 3:
			res = transactionService.dispBal(customer,amt);
			System.out.println("Balance is" + res);
			break;

		case 4:
			transaction.setFromAccountNo(customer.getAccountNo());
			System.out.println("Enter destination account no");
			transaction.setToAccountNo(sc.nextLong());
			System.out.println("Enter amount to be transferred");
			transaction.setAmountTransferred(sc.nextLong());
			transaction = custservice.fundTransfer(transaction);
			if (transaction != null) {
				System.out.println(transaction.getAmountTransferred() + " is transferred from "
						+ transaction.getFromAccountNo() + " to " + transaction.getToAccountNo());
			System.out.println("Transaction Id is"+transaction.getTransactionId());
			}
			else
				try {
					throw new TransactionException();
				} catch (TransactionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		App app = new App();
		Customer customer = new Customer();
		Customer customer1 = new Customer();
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Enter 1. Register 2. Login 3.Exit");
		int c = sc.nextInt();
		switch (c) {
		case 1:
			System.out.println("Enter first_name");
			customer.setFirstName(sc.next());
			System.out.println("Enter last_name");
			customer.setLastName(sc.next());
			System.out.println("Enter email");
			customer.setEmailId(sc.next());
			System.out.println("Enter password");
			customer.setPassword(sc.next());
			System.out.println("Enter pan card ");
			customer.setPancardNo(sc.next());
			System.out.println("Enter aadhaar no");
			customer.setAadhaarNo(sc.next());
			System.out.println("Enter address");
			customer.setAddress(sc.next());
			System.out.println("Enter mobile number");
			customer.setMobileNo(sc.next());
			customer.setBalance(0);

			customer1 = custservice.register(customer);
			if (customer1 == null) {
				try {
					throw new InvalidInputException();
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Welcome "+customer1.getFirstName());
				System.out.println("Account No is " +customer1.getAccountNo());
			}
			break;
		case 2:
			System.out.println("Enter account no");
			long acc = sc.nextLong();
			System.out.println("Enter password");
			String pswd = sc.next();
			customer1 = custservice.login(acc, pswd);
			if (customer1 != null) {
				System.out.println("Welcome " + customer1.getFirstName());
				app.disp(customer1);
			} else
				try {
					throw new InvalidIDException();
				} catch (InvalidIDException e) {
					e.printStackTrace();
				}
			break;
		case 3:System.exit(0);

		}
		}while(true);
	}

}
  
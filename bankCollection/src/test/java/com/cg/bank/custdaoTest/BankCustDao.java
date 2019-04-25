package com.cg.bank.custdaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.cg.bank.custdao.CustDAOImpl;
import com.cg.bank.customer.Customer;
import com.cg.bank.customer.Transaction;
import com.cg.bank.transdao.TransDAOImpl;

class BankCustDao {

	
	
		long bal=0;
		CustDAOImpl cust=new CustDAOImpl();
		TransDAOImpl trans = new TransDAOImpl();
		Customer customer=new Customer();
		Transaction transaction=new Transaction();
		Customer customer1=new Customer();

		@Test
		void testRegister() {
			customer.setAadhaarNo("123157786787");
			customer.setAddress("Hyd");
			customer.setBalance(1000);
			customer.setEmailId("pallavi@gmail.com");
			customer.setFirstName("pallavi");
			customer.setLastName("buroju");
			customer.setMobileNo("9387498375");
			customer.setPancardNo("276885");
			customer.setPassword("pal");
			customer1= cust.register(customer);
			long acc=customer1.getAccountNo();
			assertEquals(1,acc);
			
		}

		@Test
		void testLogin() {
			customer1=cust.login(1, "pal");
			System.out.println(customer1.getAccountNo());
			assertEquals(customer1,customer1);
		}

		@Test
		void testDeposit() {
			 bal=trans.deposit(customer, 1000);
			 customer.setBalance(bal);
			assertEquals(1000,customer.getBalance());
		}

		@Test
		void testWithdrawl() {
			customer.setBalance(10000);
			assertEquals(5000, trans.withdrawl(customer,5000));
		}

		@Test
		void testShowBal() {
			customer.setBalance(1000);
			bal=trans.showBal(customer, bal);
			assertEquals(1000, bal);
		}

		@Test
		void testFundTransfer() {
			transaction.setAmountTransferred(10);
			transaction.setFromAccountNo(4);
			transaction.setToAccountNo(5);
			assertEquals(null, cust.fundTransfer(transaction));
		}

}



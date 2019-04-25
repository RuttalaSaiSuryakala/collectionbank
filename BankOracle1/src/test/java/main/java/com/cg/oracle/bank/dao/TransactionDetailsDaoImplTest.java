package main.java.com.cg.oracle.bank.dao;

import junit.framework.TestCase;

public class TransactionDetailsDaoImplTest extends TestCase {
	TransactionDetailsDaoImpl dao= new TransactionDetailsDaoImpl();
	public void testDeposit() throws Exception {
		//fail("Not yet implemented");
		double expected=2000;
		double actual=dao.deposit(1000, 1000);
		assertEquals(expected,actual);
	}

	public void testDebit() throws Exception {
		//fail("Not yet implemented");
		double expected=1000;
		double actual=dao.debit(1000, 1000);
		assertEquals(expected,actual);
		
	}

	public void testCheckBalance() throws Exception {
		//fail("Not yet implemented");
		double expected=1000;
		double actual=dao.checkBalance(1000);
		assertEquals(expected,actual);
		

	}

	public void testFundTransfer() throws Exception {
		//fail("Not yet implemented");
	double actual=	dao.fundTransfer(1000, 1001, 10000);
		double expected=0;
		assertEquals(expected,actual);
	}

}

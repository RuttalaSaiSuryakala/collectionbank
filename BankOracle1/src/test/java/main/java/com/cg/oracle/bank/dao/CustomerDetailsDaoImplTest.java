package main.java.com.cg.oracle.bank.dao;

import junit.framework.TestCase;
import main.java.com.cg.oracle.bank.beans.Customer;

public class CustomerDetailsDaoImplTest extends TestCase {
	Customer customer = new Customer();
	CustomerDetailsDaoImpl dao= new CustomerDetailsDaoImpl();
	
	
	public void testRegistration() throws Exception {
		//fail("Not yet implemented");
		
		customer.setAadharNo("147852136945");
		customer.setAddress("hyd");
		customer.setBalance(0);
		customer.setEmail("emmey@gmail.com");
		customer.setLastName("john");
		customer.setFirstName("emmey");
		customer.setMobile("7531115985");
		customer.setPancardNo("741852963");
		
		customer.setPassword("Emmey@123");
	assertEquals(1028,dao.registration(customer));
	}

	public void testLogin() throws Exception {
		//fail("Not yet implemented");
		boolean actual=dao.login(1000,"harsha@123");
		boolean expected= true;
		assertEquals(actual,expected);
		
	}

}

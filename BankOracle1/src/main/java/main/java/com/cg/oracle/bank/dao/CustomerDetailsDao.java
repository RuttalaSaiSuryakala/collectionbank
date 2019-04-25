package main.java.com.cg.oracle.bank.dao;

import main.java.com.cg.oracle.bank.beans.*;

public interface CustomerDetailsDao {
	
	long registration(Customer customer) throws Exception;
	boolean login(long accountNo, String password) throws Exception;

}

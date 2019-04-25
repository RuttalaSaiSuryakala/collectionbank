package com.cg.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.exception.CustomerDoesnotExist;
import com.cg.model.CustomerDetails;

@Repository
@Component
public class BankDaoImpl implements BankDao {

	public CustomerDetails setInfo() {
		// TODO Auto-generated method stub
		CustomerDetails customer = new CustomerDetails();
		customer.setFirstName("surya");
		customer.setLastName("kala");
		customer.setEmailId("suryakala@gmail.com");
		customer.setAadharNo("123412341234");
		customer.setMobileNo("8332063946");
		customer.setPancardNo(123445);
		customer.setPassword("surya");
		customer.setAddress("Hyd");
		customer.setBalance(1000);
		customer.setAccountNo(101);
		return customer;
	}

	public CustomerDetails register(@RequestBody CustomerDetails cd) {
		// TODO Auto-generated method stub
		return cd;
	}

	public int login(ArrayList<CustomerDetails> custList, CustomerDetails c)  {
		// TODO Auto-generated method stub
		int accNo = 0;
	//	System.out.println(c.getAccountNo());
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == c.getAccountNo() && customerDetails.getPassword().equals(c.getPassword())) {
				accNo = c.getAccountNo();
			}
			
		}
		return accNo;
	}
}

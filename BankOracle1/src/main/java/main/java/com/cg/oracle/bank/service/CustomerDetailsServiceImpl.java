package main.java.com.cg.oracle.bank.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.cg.oracle.bank.beans.Customer;
import main.java.com.cg.oracle.bank.dao.*;
import main.java.com.cg.oracle.bank.exceptions.InvalidPassword;

public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	CustomerDetailsDao customerDetails = new CustomerDetailsDaoImpl();

	public long registration(Customer customer) throws Exception {
		return customerDetails.registration(customer);
	}

	public boolean login(long accountNo, String password) throws Exception {
		return customerDetails.login(accountNo, password);
	}

	public boolean validAadhar(String aadhar) {
		return (aadhar.length() == 12);
	}

	public boolean validMobile(String aadhar) {
		return (aadhar.length() == 10);
	}

	public boolean checkPassword(String pwd) throws Exception {
		if (pwd.length() >= 8) {
			Pattern letter = Pattern.compile("[a-zA-Z]");
			Pattern digit = Pattern.compile("[0-9]");
			Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

			Matcher hasLetter = letter.matcher(pwd);
			Matcher hasDigit = digit.matcher(pwd);
			Matcher hasSpecial = special.matcher(pwd);

			if (hasLetter.find() && hasDigit.find() && hasSpecial.find()) {
				return true;
			} else
				throw new InvalidPassword(
						"Password not valid please register again.\nPassword must have >8 chars\none caps\none digit\none special char.");
		}

		else
			throw new InvalidPassword(
					"Password not valid please register again.\nPassword must have >8 chars\none caps\none digit\none special char.");

	}

}

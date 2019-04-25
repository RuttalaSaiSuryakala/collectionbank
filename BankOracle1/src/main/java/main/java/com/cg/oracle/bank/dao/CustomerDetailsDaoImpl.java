package main.java.com.cg.oracle.bank.dao;

import java.sql.*;
import main.java.com.cg.oracle.bank.beans.*;
import main.java.com.cg.oracle.bank.exceptions.*;
import main.java.com.cg.oracle.bank.utility.*;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {

	Customer customer = new Customer();
	static Database con = new Database();

	public long registration(Customer customer) throws Exception {
		PreparedStatement pst1 = con.connect()
				.prepareStatement("insert into registervalue values(Account_noseq.nextval,?,?,?,?,?,?,?,?,?)");
		// pst1.setLong(1, customer.getAccountNo());
		pst1.setString(1, customer.getFirstName());
		pst1.setString(2, customer.getLastName());
		pst1.setString(3, customer.getEmail());
		pst1.setString(4, customer.getPassword());
		pst1.setString(5, customer.getAadharNo());
		pst1.setString(6, customer.getMobile());
		pst1.setDouble(7, customer.getBalance());
		pst1.setString(8, customer.getPancardNo());
		pst1.setString(9, customer.getAddress());
		

		int i = pst1.executeUpdate();
		if (i == 1) {
			PreparedStatement pst2 = con.connect().prepareStatement("select account_no from registervalue where aadhar_no=?");
			pst2.setString(1, customer.getAadharNo());
			ResultSet rst = pst2.executeQuery();
			while (rst.next()) {
				return rst.getInt(1);
			}
		}
		return 0;
	}
	
	public boolean login(long accountNo, String password) throws Exception {
	
		PreparedStatement pst = con.connect()
				.prepareStatement("select password from registervalue where account_no=" + accountNo);
		ResultSet rs = pst.executeQuery();
		rs.next();
		if (rs.getString("password").equals(password)) {
			return true;
		} else
			throw new InvalidPassword("Invalid Password");
	}

}
 
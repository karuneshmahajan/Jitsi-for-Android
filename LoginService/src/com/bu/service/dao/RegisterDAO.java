package com.bu.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bu.service.login.Contact;

public class RegisterDAO {
	
	Connection conn= null;

	public boolean registerUser(Contact contact) throws ClassNotFoundException, SQLException{
		Statement stmt = null;
		boolean status=false;
		int count=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://jitsi-bu-mysql-instance1.cwxrlbzxd0ib.us-west-2.rds.amazonaws.com:3306","Jitsiandroid1","Jitsiandroid1");
			stmt = conn.createStatement();
			count = stmt.executeUpdate("INSERT INTO JITSIBU.CONTACT VALUES('"+contact.getFirstName()+"','"+contact.getLastName()+"','"+contact.getEmailID()+"','"+contact.getPassword()+"',NULL)");
			if(count==1){
		    	contact.setResponseMessage("Registered");	
		    	System.out.println(contact.getResponseMessage());
		    }
		    else if(count==0){
		    	contact.setResponseMessage("Error Occured");		    	
		    }
		    
		    else contact.setResponseMessage("Error Occured");
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close();
		}
		
		return status;
		
	}
}

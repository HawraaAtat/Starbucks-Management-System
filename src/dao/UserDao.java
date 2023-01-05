/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author HP
 */
public class UserDao {

	
    public static void save(User user) {
    	
        String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status,salary) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false','1000')";
        DBOperations.setDataorDelete(query, "Registered Successfully Wait for Admin Approval!");
        
    }

    
    
    
    public static User login(String email, String password) {
    	
        User user = null;
        
        try {
        	
        	
            ResultSet rs = DBOperations.getdata("select * from user where email ='" + email + "'and password = '" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
            
        }
        return user;
        
    }

    
    
    public static User getSecurityQuestion(String email) {
    	
        User user = null;
        
        try {
        	
        	
            ResultSet rs = DBOperations.getdata("select * from user where email = '"+email+"'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
            
        }
        
        return user;
    }

    
    
    public static void update(String email, String newPassword) {
    	
        String query = "update user set password = '" + newPassword + "'where email = '" + email + "'";
        DBOperations.setDataorDelete(query,"Password Changed Successfully");
        
    }
    
    
    
	public static ArrayList<User> getAllRecords(String email) {

		ArrayList<User> arrayList = new ArrayList<>();
		
		try {
			
			ResultSet rs = DBOperations.getdata("select * from user where email like '%" + email + "%'");
			while (rs.next()) 
				{
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setMobileNumber(rs.getString("mobileNumber"));
					user.setAddress(rs.getString("address"));
					user.setSecurityQuestion(rs.getString("securityQuestion"));
					user.setStatus(rs.getString("status"));
					arrayList.add(user);
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		
		}
		
		return arrayList;

	}
    
	
    
    
	public static void changeStatus(String email, String status) {
		
        String query = "update user set status='"+status+"' where email = '"+email+"'";
		DBOperations.setDataorDelete(query, "Status Changed Successfully");
		
	}
    
    
    
	public static void changePassword(String email, String oldPassword, String newPassword) {
		
		try {

			
			ResultSet rs = DBOperations.getdata("select * from user where email = '"+email+"' and password = '"+oldPassword+"'");
			if (rs.next()) {
				update(email, newPassword);
			} else
				JOptionPane.showMessageDialog(null, "Old Password is Wrong");

			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
    
    
    
   
	public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {
		try {

			ResultSet rs = DBOperations.getdata("select * from user where email = '" + email + "' and password = '" + password + "'");
			
			if (rs.next()) {
				update(email, securityQuestion, answer);
			} else
				JOptionPane.showMessageDialog(null, "Password is Wrong");

		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, e);
			
		}
		
		
	}
	
	

	public static void update(String email, String securityQuestion, String answer) {
		
		String query = "update user set securityQuestion = '" + securityQuestion + "',answer = '" + answer + "' where email = '" + email + "'";
		DBOperations.setDataorDelete(query, "Security Question Changed Successfully");
		
	}
	
	
	
	public static void updateSalary(String email,double newSalary) {
		
		String query = "update user set salary = '" + newSalary + "' where email = '" + email + "'";
		DBOperations.setDataorDelete(query, "Salary Is Changed Successfully");
		
	}
	
	public static double selectSalary(String email) {
		
                
                double sal=0;
                try {
                    ResultSet rs = DBOperations.getdata("select salary from user where email = '" + email + "'");
                    while (rs.next()) {
                     sal=rs.getDouble("salary");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                return sal;

                }
	
}

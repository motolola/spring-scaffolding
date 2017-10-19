package com.motolola.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.motolola.model.UserGroup;

@Controller 
public class MysqlTest {
	
	@RequestMapping(value = "/mysql", method = RequestMethod.GET)
	public String showPage(ModelMap model)
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sidscci","root", "" );
			Statement myStmt = myConn.createStatement();
			ResultSet myRs  = myStmt.executeQuery("SELECT * FROM user_group");
			
			ArrayList<UserGroup> result = new ArrayList<UserGroup>();
			while(myRs.next()) {
				UserGroup group = new UserGroup(0, null, null);
				group.setId(myRs.getInt("id"));
				group.setName(myRs.getString("groupname"));
				group.setDescription(myRs.getString("description"));
				result.add(group);
			}
			model.addAttribute("result", result);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "mysql";
	}

}

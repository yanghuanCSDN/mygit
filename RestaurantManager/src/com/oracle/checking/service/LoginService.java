package com.oracle.checking.service;

import java.sql.SQLException;

import com.oracle.checking.dao.ManagerLogin;
import com.oracle.checking.unit.Manager;

public class LoginService {
   //����boss����
	ManagerLogin LoginService1=new ManagerLogin();
	public Manager resiveBossDate() throws SQLException{
		return  LoginService1.login();
	}
}

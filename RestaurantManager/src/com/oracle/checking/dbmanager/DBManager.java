package com.oracle.checking.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//连接数据库
//创建修改，查询方法
public class DBManager {
	static final String CLASSNAME = "oracle.jdbc.OracleDriver";
	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	static final String USER = "system";
	static final String PASSWORD = "oracle";
	
	ResultSet set;
	Connection con;
	PreparedStatement psta;
	
	//加载驱动
	static {
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//增删改----
	public int executeUpdate(String sql, Object... arr) throws SQLException{
		con = DriverManager.getConnection(
						URL, USER, PASSWORD);
				
		psta = con.prepareStatement(sql);
		
		for (int i=0; i<arr.length; i++)
			psta.setObject(i+1, arr[i]);
		
		int res = psta.executeUpdate();
		
		psta.close();
		con.close();
		
		return res;
	}
	
	//查
	public ResultSet executeQuery(String sql, Object... arr) throws SQLException{
		con = DriverManager.getConnection(
						URL, USER, PASSWORD);
		
		psta = con.prepareStatement(sql);
		for (int i=0; i<arr.length; i++)
			psta.setObject(i+1, arr[i]);
		
		set = psta.executeQuery();
		
		return set;
	}
	
	public void closeOper() throws SQLException{
		if (set != null)
			set.close();
		if (psta != null)
			psta.close();
		if (con != null)
			con.close();

    }
}

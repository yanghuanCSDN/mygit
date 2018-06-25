package com.yanghuan.dbmanager;

import java.sql.Connection;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 用于与数据库连接
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DbManager {
	private static final String className ="oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "yanghuan";
	private static final String password = "oracle";
	private static Connection connection;
	
	//加载驱动
	static{
		try {
				Class.forName(className);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	//获得连接
	private Connection getConnection(){
		try {
			if(connection==null || connection.isClosed()){
				connection=DriverManager
						.getConnection(url, user, password);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
				return connection;
	}
	public ResultSet executeQuary(String sql, Object... prams){
		try {
			//创建命令
			PreparedStatement preparedStatement=
				getConnection().prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				preparedStatement.setObject(i+1, prams[i]);
			}
			//进行查询
				return preparedStatement.executeQuery();
		} catch (SQLException e) {
				e.printStackTrace();
		}
				return null;
	}
	public int executeUpdate(String sql, Object... prams){
		try {
			//创建命令
			PreparedStatement preparedStatement=
				getConnection().prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				preparedStatement.setObject(i+1, prams[i]);
			}
			//进行修改
				return preparedStatement.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		  }
		return -1;
	}
	protected void finalize() throws Throwable {
		if(connection!=null && !connection.isClosed()){
				connection.close();
		}
				super.finalize();
	}
	
}

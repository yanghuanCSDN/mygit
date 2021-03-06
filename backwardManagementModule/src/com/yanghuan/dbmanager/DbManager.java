package com.yanghuan.dbmanager;
import java.sql.Connection;
/*
 * DbManager类创建者：杨欢
 * 加载驱动:Class.forName(className)
 * 创建连接:getConnection()
 * 查找:executeQuary(String sql, Object... prams)
 * 更改:executeUpdate(String sql, Object... prams)
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DbManager {
	private static final String className ="oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "yanghuan";
	private static final String password = "123456";
	private static Connection connection;
	static{
		try {
				Class.forName(className);
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
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
			PreparedStatement preparedStatement=
				getConnection().prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				preparedStatement.setObject(i+1, prams[i]);
			}
				return preparedStatement.executeQuery();
		} catch (SQLException e) {
				e.printStackTrace();
		}
				return null;
	}
	public int executeUpdate(String sql, Object... prams){
		try {
			PreparedStatement preparedStatement=
				getConnection().prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				preparedStatement.setObject(i+1, prams[i]);
			}
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

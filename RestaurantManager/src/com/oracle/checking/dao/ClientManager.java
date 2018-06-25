package com.oracle.checking.dao;

import java.security.AllPermission;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.oracle.checking.dbmanager.DBManager;
import com.oracle.checking.unit.Client;


public class ClientManager{
	DBManager dbmanager=new DBManager();
	
	
	//查找一条记录
	public Client selectById(int clientid) throws SQLException{
		String sql="select * from client where clientid=?";
		ResultSet set=dbmanager.executeQuery(sql,clientid);
		if(set.next()){
			int clid = set.getInt("clientid");
			int clpwd = set.getInt("clientpwd");
			String clname = set.getString("clientname");
			Date clbirthday = set.getDate("clientbirthday");
			int clgrade = set.getInt("clientgrade");
			String clkind = set.getString("clientkind");
			
			return new Client(clid,clpwd,clname,clbirthday,clgrade,clkind);
		}
		else{
			return null;
		}
	}
	//查找所有普通顾客信息
		public ArrayList<Client> selectById1() throws SQLException{
			String sql="select * from client ";
			ResultSet set=dbmanager.executeQuery(sql);
			ArrayList<Client> t=new ArrayList<Client>();
			//对结果解析
			while(set.next()){
				int clid = set.getInt("clientid");
				int clpwd = set.getInt("clientpwd");
				String clname = set.getString("clientname");
				Date clbirthday = set.getDate("clientbirthday");
				int clgrade = set.getInt("clientgrade");
				String clkind = set.getString("clientkind");
				Client client=new Client(clid,clpwd,clname,clbirthday,clgrade,clkind);
				t.add(client);
				}
			return t;
		}
	//插入用户
	public int insertUser(int clientid,int clientpwd,String clientname,Date clientbirthday,int clientgrade,String clientkind) throws SQLException{
		String sql = "insert into client values (?,?,?,?,?,?)";
		int res=dbmanager.executeUpdate(sql,clientid,clientpwd,clientname,clientbirthday,clientgrade,clientkind);
		return res;
	}
	//删除用户
	public int deleteUser(int clientid) throws SQLException{
		String sql="DELETE FROM client WHERE clientid=?";
		int res=dbmanager.executeUpdate(sql,clientid);
		return res;
	}
}

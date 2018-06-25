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
	
	
	//����һ����¼
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
	//����������ͨ�˿���Ϣ
		public ArrayList<Client> selectById1() throws SQLException{
			String sql="select * from client ";
			ResultSet set=dbmanager.executeQuery(sql);
			ArrayList<Client> t=new ArrayList<Client>();
			//�Խ������
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
	//�����û�
	public int insertUser(int clientid,int clientpwd,String clientname,Date clientbirthday,int clientgrade,String clientkind) throws SQLException{
		String sql = "insert into client values (?,?,?,?,?,?)";
		int res=dbmanager.executeUpdate(sql,clientid,clientpwd,clientname,clientbirthday,clientgrade,clientkind);
		return res;
	}
	//ɾ���û�
	public int deleteUser(int clientid) throws SQLException{
		String sql="DELETE FROM client WHERE clientid=?";
		int res=dbmanager.executeUpdate(sql,clientid);
		return res;
	}
}

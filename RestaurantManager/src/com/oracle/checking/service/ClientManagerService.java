package com.oracle.checking.service;

import java.sql.SQLException;
import java.util.ArrayList;


import java.util.Date;

import com.oracle.checking.dao.ClientManager;
import com.oracle.checking.unit.Client;

public class ClientManagerService {
	private ClientManager dao=new ClientManager();
    //查找普通顾客所有的信息
	public ArrayList<Client> getClient() throws SQLException{
		return dao.selectById1();
	}
	//查找表中一条记录的信息
	public Client getClient(int clientid) throws SQLException{
		return dao.selectById(clientid);
	}
	//添加
	public int insertUser(int clientid,int clientpwd,String clientname,Date clientbirthday,int clientgrade,String clientkind) throws SQLException{
		return dao.insertUser(clientid, clientpwd, clientname, clientbirthday, clientgrade, clientkind);
	}
	//删除
	public int deleteUser(int clientid) throws SQLException{
		return dao.deleteUser(clientid);
	}
}

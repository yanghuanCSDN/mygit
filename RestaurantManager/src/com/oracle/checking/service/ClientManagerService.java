package com.oracle.checking.service;

import java.sql.SQLException;
import java.util.ArrayList;


import java.util.Date;

import com.oracle.checking.dao.ClientManager;
import com.oracle.checking.unit.Client;

public class ClientManagerService {
	private ClientManager dao=new ClientManager();
    //������ͨ�˿����е���Ϣ
	public ArrayList<Client> getClient() throws SQLException{
		return dao.selectById1();
	}
	//���ұ���һ����¼����Ϣ
	public Client getClient(int clientid) throws SQLException{
		return dao.selectById(clientid);
	}
	//���
	public int insertUser(int clientid,int clientpwd,String clientname,Date clientbirthday,int clientgrade,String clientkind) throws SQLException{
		return dao.insertUser(clientid, clientpwd, clientname, clientbirthday, clientgrade, clientkind);
	}
	//ɾ��
	public int deleteUser(int clientid) throws SQLException{
		return dao.deleteUser(clientid);
	}
}

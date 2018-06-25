package com.oracle.checking.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dao.employDao;
import com.oracle.checking.unit.Employ;

//import com.oracle.Dao.employDao;
//import com.oracle.Test.Employ;

public class employService {
	private employDao dao = new employDao();
	
	//��ȡ��Employ���������Ϣ
	public ArrayList<Employ> GetEmployInfo() throws SQLException{
		return dao.selectInfo();
	}
	
	//ɾ����Employ�е���Ϣ
	public void DeleteInfo(int id) throws SQLException{
		dao.deleteByID(id);
	}
	
	//��Employ���в�����Ϣ
	public void InsertInfo(int id,String name, int age,
			String sex, String address, Date hiredate, int sal) throws SQLException{
		dao.insertInfo(id,name, age, sex, address, hiredate, sal);
	}
	
	//�޸ı�Employ����Ϣ
	public void UpdateInfo(String name, int age, String sex, 
			String address, Date hiredate, int sal, int id) throws SQLException{
		dao.updateInfo(name, age, sex, address, hiredate, sal, id);
	}
	
	//����ID��ѯ��Employ����Ϣ
	public void SelectByID(){
		//dao.
	}
}


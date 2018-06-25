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
	
	//获取表Employ里的所有信息
	public ArrayList<Employ> GetEmployInfo() throws SQLException{
		return dao.selectInfo();
	}
	
	//删除表Employ中的信息
	public void DeleteInfo(int id) throws SQLException{
		dao.deleteByID(id);
	}
	
	//向Employ表中插入信息
	public void InsertInfo(int id,String name, int age,
			String sex, String address, Date hiredate, int sal) throws SQLException{
		dao.insertInfo(id,name, age, sex, address, hiredate, sal);
	}
	
	//修改表Employ中信息
	public void UpdateInfo(String name, int age, String sex, 
			String address, Date hiredate, int sal, int id) throws SQLException{
		dao.updateInfo(name, age, sex, address, hiredate, sal, id);
	}
	
	//根据ID查询表Employ中信息
	public void SelectByID(){
		//dao.
	}
}


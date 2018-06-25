package com.oracle.checking.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dbmanager.DBManager;
import com.oracle.checking.unit.Employ;


//import com.oracle.Test.Employ;
//import com.oracle.Test.EmploySex;
//import com.oracle.Test.employEnter;



public class employDao {
	DBManager dbmanager = new DBManager();
	
	//按ID查询信息
	public Employ selectById(int id) throws SQLException{
		String sql = "select * from employ where eid=?";
		ResultSet set = dbmanager.executeQuery(sql, id);
		
		if (set.next()){
			int eid = set.getInt("eid");
			String ename = set.getString("ename");
			int eage = set.getInt("eage");
			String esex = set.getString("esex");
			String eaddress = set.getString("eaddress");
			Date ehiredate = set.getDate("ehiredate");
			int esal = set.getInt("esal");
			return new Employ(eid, ename, eage, esex, eaddress, 
					ehiredate, esal);
		} else {
			return null;
		}		
	}
	
	
	//查询所有信息
	public ArrayList<Employ> selectInfo() throws SQLException{
		ArrayList<Employ> arr = 
				new ArrayList<Employ>();
		
		String sql = "SELECT * FROM employ";
		
		ResultSet set = dbmanager.executeQuery(sql);

		while (set.next()){
				int eid = set.getInt("eid");
				String ename = set.getString("ename");
				int eage = set.getInt("eage");
				String esex = set.getString("esex");
				String eaddress = set.getString("eaddress");
				Date ehiredate = set.getDate("ehiredate");
				int esal = set.getInt("esal");
				//String ssex = set.getString("ssex");
				
				//EmploySex ee = new EmploySex(ssex);
			    Employ e = new Employ(eid, ename, eage, esex, eaddress, 
					ehiredate, esal);
			        arr.add(e);
		}
		return arr;
	}
	
	
	//删除某条记录
	public int deleteByID(int id) throws SQLException{
		String sql = "delete from employ where eid = ?";
		
		int res = dbmanager.executeUpdate(sql, id);
		return res;
	}
	
	
	//插入用户信息
	public int insertInfo(int id,String name,int age,String sex,
				String address,Date hiredate,int sal) throws SQLException{
		
		String sql = "insert into employ values(?,?,?,?,?,?,?)";
		int res = dbmanager.executeUpdate(sql,id,name,age,sex,address,hiredate,sal);
		
		 return res;
	}
	
	//修改用户信息
	public int  updateInfo(String name,int age,String sex,
			String address,Date hiredate,int sal,int id) throws SQLException{
		
		String sql = "update employ set ename=?,eage=?,esex=?,eaddress=?,"
				+"ehiredate=?,esal=? where eid=?";
		int res = dbmanager.executeUpdate(sql,name,age,sex,address,hiredate,sal,id);
		
		return res;
	}
}

package com.oracle.checking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.oracle.checking.dbmanager.DBManager;
import com.oracle.checking.unit.Manager;
//boss��Dao
public class ManagerLogin {
	//��ѯmanager�е�����
     private DBManager manager=new DBManager();
    //�õ�Manager�е�����
     public Manager login() throws SQLException{
    	 String sql="select *from manager1";
    	 ResultSet manager1=manager.executeQuery(sql);
    	 //�������
         if(manager1.next()){
   	        int id=manager1.getInt("id");
           	String name=manager1.getString("name");
           	String pwd=manager1.getString("pwd");
             Manager t=new Manager( id, name,pwd);
             return t;
           }else{
   	        return null;
         }
     }
		 
}

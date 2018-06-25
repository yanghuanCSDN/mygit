package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yanghuan.model.User;
/*
 * 对从数据库得到的结果进行解析
 * getList(ResultSet  set)
 */
public  class GetList {
	public	List<User> getList(ResultSet  set){
		try {
			List<User>	userinfos=new	ArrayList<User>();
			while(set.next()){
				userinfos.add(
					new  User(
							set.getInt("personid"),
							set.getString("qqnumber"),
							set.getString("personsignature"),
							set.getString("realname"), 
							set.getString("idcard"),
							set.getString("cellphonenumber"), 
							set.getInt("judgeopened"),
							set.getDate("submissiontime")
							)
					);
			}
				return	userinfos;
		} catch (SQLException e) {
			e.printStackTrace();
		  }
				return null;
	}
}

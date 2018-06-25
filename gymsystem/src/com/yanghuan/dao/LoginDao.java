package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.Coach;
import com.yanghuan.model.ForegroundPeople;
import com.yanghuan.model.Manager;
/**
 * ������̨����ϵͳ   1.0�汾
 * 2017-11-5~2017-11-10
 * ��¼
 * @author Administrator
 *
 */
public class LoginDao {
    DbManager dbManager=new DbManager();
    //����Ա
    public Manager getManager(String userName,String password){
    	String sql="select *from manager where mname=?" +
    			" and mpassword=?";
    	ResultSet set=dbManager.executeQuary(sql, userName,password);
    	Manager manager = null;
    	try {
			if(set.next()){
					 manager=new Manager(
							set.getInt("mId"),
							set.getString("mName"),
							set.getString("mPassword"),
							set.getString("mIdCard"),
							set.getString("mPhone"),
							set.getString("mSex"),
							set.getString("mPage")
							);
			}
			return manager;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    //����
    public Coach getCoach(String userName,String password){
    	String sql=" select *from coach" +
    			"  where cName=?and cPassword=?";
    	ResultSet set=dbManager.executeQuary(sql, userName,password);
    	Coach coach= null;
    	try {
			if(set.next()){
				coach=new Coach(
							set.getInt("cId"),
							set.getString("cName"),
							set.getString("cIdcard"),
							set.getString("cPassword"),
							set.getString("cPhone"),
							set.getString("cSex"),
							set.getString("cPay"),
							set.getString("cJobkind"),
							set.getDate("entryTime"),
							set.getDate("endTime"),
							set.getInt("registerSign"),
							set.getString("cPage"),
							set.getInt("state")
							);
			}
			return coach;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
    //ǰ̨��Ա
    public ForegroundPeople getForegroundPeople(String userName,String password){
    	String sql=" select *from foregroundPeople" +
    			"  where fname=? and fpassword=?";
    	ResultSet set=dbManager.executeQuary(sql, userName,password);
    	ForegroundPeople foregroundPeople= null;
    	try {
			if(set.next()){
				foregroundPeople=new ForegroundPeople(
							set.getInt("fId"),
							set.getString("fName"),
							set.getString("fPassword"),
							set.getString("fPhone"),
							set.getString("fSex"),
							set.getString("fPay"),
							set.getDate("enterTime"),
							set.getDate("endTime"),
							set.getString("fPage"),
							set.getInt("fSign"),
							set.getInt("state")
							);
			}
			return foregroundPeople;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
}

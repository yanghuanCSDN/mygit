package com.yanghuan.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.User;
/*
 * BackwardManagementDao类创建者：杨欢
 * 查询所有用户信息 :getAll()
 * 查已开通用户信息:getAllDredge()
 * 查未开通用户信息:getAllNotDredge()
 * 通过QQ查询用户:getUserinfoByQQ(String qqnumber)
 * 通过提交时间查询用户:getUserinfoByTime(String submissiontime)
 * 修改:applicationPublicSpace(int judgeopened,int personId)
 */
public class BackwardManagementDao {
	private DbManager	dbManager=new DbManager();
	public List<User> getAll(){
		String sql="select personid, qqnumber, personsignature, realname," +
				" 	idcard, cellphonenumber, judgeopened, submissiontime " +
				"	from userinfo order by personid";
		ResultSet	set=dbManager.executeQuary(sql);
		List<User> user=new GetList().getList(set);
		return user;
	}
	public List<User> getAllDredge() {
		String sql="select personid, qqnumber, personsignature, realname," +
				" 	idcard, cellphonenumber, judgeopened, submissiontime " +
				"	from userinfo" +
				"   where  judgeopened=0 " +
				"	order by personid";
		ResultSet	set=dbManager.executeQuary(sql);
		List<User> user=new GetList().getList(set);
		return user;
	}
	public List<User> getAllNotDredge() {
		String sql="select personid, qqnumber, personsignature, realname," +
				" 	idcard, cellphonenumber, judgeopened, submissiontime " +
				"	from userinfo where	judgeopened=1 " +
				"	order by personid";
		ResultSet	set=dbManager.executeQuary(sql);
		List<User> user=new GetList().getList(set);
		return user;
	}
	public List<User> getUserinfoByQQ(String qqnumber) {
		String sql="select personid, qqnumber, personsignature, realname," +
				" 	idcard, cellphonenumber, judgeopened, submissiontime " +
				"	from userinfo where	qqnumber=? " +
				"	order by personid";
		ResultSet	set=dbManager.executeQuary(sql, qqnumber);
		List<User> user=new GetList().getList(set);
		return user;
	}
	public List<User> getUserinfoByTime(String submissiontime) {
		String sql="select personid, qqnumber, personsignature, realname, idcard," +
				"	cellphonenumber, judgeopened, submissiontime from userinfo" +
				"	where  to_char(submissiontime, 'yyyy-MM-dd ') like ?" +
				"	order by personid";
		ResultSet	set=dbManager.executeQuary(sql, submissiontime+"%");
		List<User> user=new GetList().getList(set);
		return user;
	}
	public Boolean applicationPublicSpace(int judgeopened,int personId) {
		String sql="update userinfo" +
				"	set judgeopened = ?," +
				"	submissiontime =sysdate" +
				"	where personid = ?";
		int count=dbManager.executeUpdate(sql, judgeopened,personId);
		if(count==1){
			return true;
		}else{
			return false;
		}
	}
}

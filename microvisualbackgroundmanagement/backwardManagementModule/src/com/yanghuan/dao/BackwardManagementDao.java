package com.yanghuan.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.User;
/*
 * BackwardManagementDao�ഴ���ߣ��
 * ��ѯ�����û���Ϣ :getAll()
 * ���ѿ�ͨ�û���Ϣ:getAllDredge()
 * ��δ��ͨ�û���Ϣ:getAllNotDredge()
 * ͨ��QQ��ѯ�û�:getUserinfoByQQ(String qqnumber)
 * ͨ���ύʱ���ѯ�û�:getUserinfoByTime(String submissiontime)
 * �޸�:applicationPublicSpace(int judgeopened,int personId)
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

package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.Coach;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 教练
 * @author Administrator
 *
 */
public class CoachDao {
	DbManager dbManager=new DbManager();
	private static final long PAGESIZE = 5;
	//根据名字搜索教练信息
	public List<Coach> getOne(String cname){
		String sql="select *from coach where cname=?";
		ResultSet rs=dbManager.executeQuary(sql,cname);
		List<Coach> list=new ArrayList<Coach>();
		try {
			while(rs.next()){
				list.add(new Coach(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getString("cIdcard"),
						rs.getString("cPassword"),
						rs.getString("cPhone"),
						rs.getString("cSex"),
						rs.getString("cPay"),
						rs.getString("cJobkind"),
						rs.getDate("entryTime"),
						rs.getDate("endTime"),
						rs.getInt("registerSign"),
						rs.getString("cPage"),
						rs.getInt("state")

						));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//得到当前页数的内容
	public List<Coach> getPageCoach(int page){
		String sql="select cId, cName,cIdcard,cPassword,cPhone,cSex,cPay,cJobkind,entryTime,endTime," +
				"  registerSign," +
				"  cPage,state from " +
				"  (select cId, cName,cIdcard,cPassword,cPhone,cSex,cPay,cJobkind,entryTime," +
				"  endTime,registerSign," +
				"  cPage,state, rownum rn from coach) where rn between ? and ?";
		ResultSet rs=dbManager.executeQuary(sql,
				(page-1)*PAGESIZE+1,
				page*PAGESIZE
		);
		List<Coach> coachs=new ArrayList<Coach>();
		try {
			while(rs.next()){
				coachs.add(new Coach(
						rs.getInt("cId"),
						rs.getString("cName"),
						rs.getString("cIdcard"),
						rs.getString("cPassword"),
						rs.getString("cPhone"),
						rs.getString("cSex"),
						rs.getString("cPay"),
						rs.getString("cJobkind"),
						rs.getDate("entryTime"),
						rs.getDate("endTime"),
						rs.getInt("registerSign"),
						rs.getString("cPage"),
						rs.getInt("state")
						));
			}
			return coachs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//得到页数
	public long getPageCount() {
		String sql="select count(1) from coach";
		ResultSet rs=dbManager.executeQuary(sql);
		try {
			if(rs.next()){
				long pageCount=rs.getInt(1);
				//Math.ceil(((double)pageCount)/PAGESIZE)  为大于等于((double)pageCount)/PAGESIZE的最小整数
				pageCount=(long) Math.ceil(((double)pageCount)/PAGESIZE);
				return pageCount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//修改
	public Boolean update(String cPhone,String cPay,String endTime,int state,int cId){
		String sql="update coach set cPhone=?,cPay=?,endTime=?,state=? where cId=?";
		System.out.println(endTime);
		int decide=dbManager.executeUpdate(sql, cPhone,cPay,endTime,state,cId);
		if(decide<1){
			return false;
		}else{
			return true;
		}
	}
}

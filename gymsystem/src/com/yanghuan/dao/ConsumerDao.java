package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.Coach;
import com.yanghuan.model.Consumer;
/**
 * 健身房后台管理系统   1.0版本
 * 2017-11-5~2017-11-10
 * 顾客
 * @author Administrator
 *
 */
public class ConsumerDao {
	DbManager dbManager=new DbManager();
	private static final long PAGESIZE =  5;
	//根据名字搜索顾客信息
		public List<Consumer> getOne(String coName){
			String sql="select  *from consumer where coName=?";
			ResultSet rs=dbManager.executeQuary(sql,coName);
			List<Consumer> list=new ArrayList<Consumer>();
			try {
				while(rs.next()){
					list.add(new Consumer(
							rs.getInt("coId"),
							rs.getString("coName"),
							rs.getString("coSex"),
							/*rs.getString("coIdCard"),*/
							rs.getString("coPhone"),
							rs.getString("memberShipCard"),
							rs.getString("member_adviser"),
							rs.getString("coachName"),
							rs.getInt("fName"),
							rs.getInt("equipmentNumber"),
							rs.getInt("sendMoney"),
							rs.getInt("state"),
							rs.getString("course"),
							rs.getDate("firstTime"),
							rs.getDate("endTime"),
							rs.getString("page")
							));
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//得到当前页数的内容
		public List<Consumer> getPageConsumer(int page){
			String sql="select coId,coName,coSex,coPhone,memberShipCard,member_adviser," +
					"  coachName,fName,equipmentNumber,sendMoney,state,course,firstTime,endTime,page " +
					"  from(select coId,coName,coSex,coPhone,memberShipCard,member_adviser," +
					"  coachName,fName,equipmentNumber,sendMoney,state,course,firstTime,endTime," +
					"  page,rownum rn from consumer)where rn between ? and ?";
			ResultSet rs=dbManager.executeQuary(sql,
					(page-1)*PAGESIZE+1,
					page*PAGESIZE
			);
			System.out.println(rs);
			List<Consumer> consumers=new ArrayList<Consumer>();
			try {
				while(rs.next()){
					consumers.add(new Consumer(
							rs.getInt("coId"),
							rs.getString("coName"),
							rs.getString("coSex"),
							/*rs.getString("coIdCard"),*/
							rs.getString("coPhone"),
							rs.getString("memberShipCard"),
							rs.getString("member_adviser"),
							rs.getString("coachName"),
							rs.getInt("fName"),
							rs.getInt("equipmentNumber"),
							rs.getInt("sendMoney"),
							rs.getInt("state"),
							rs.getString("course"),
							rs.getDate("firstTime"),
							rs.getDate("endTime"),
							rs.getString("page")
							));
				}
				return consumers;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//得到页数
		public long getPageCount() {
			String sql="select count(1) from consumer";
			ResultSet rs=dbManager.executeQuary(sql);
			try {
				if(rs.next()){
					long pageCount=rs.getInt(1);
					pageCount=(long) Math.ceil(((double)pageCount)/PAGESIZE);
					return pageCount;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}
		//修改
		public Boolean update(int cid3, String detail) {
			String sql="update consumer set course=? where coId=?";
			int decide=dbManager.executeUpdate(sql,detail,cid3);
			if(decide<1){
				return false;
			}else{
				return true;
			}
		}
}

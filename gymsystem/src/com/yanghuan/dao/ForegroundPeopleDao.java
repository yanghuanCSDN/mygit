package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.Coach;
import com.yanghuan.model.ForegroundPeople;
/**
 * ������̨����ϵͳ   1.0�汾
 * 2017-11-5~2017-11-10
 * ǰ̨��Ա
 * @author Administrator
 *
 */
public class ForegroundPeopleDao {
	DbManager dbManager=new DbManager();
	private static final long PAGESIZE = 5;
	//��ѯ����ǰ̨��Ա��Ϣ
	public List<ForegroundPeople> getAll(){
		String sql="select *from foregroundPeople";
		ResultSet set=dbManager.executeQuary(sql);
		List<ForegroundPeople> list=new ArrayList<ForegroundPeople>();
		try {
			while(set.next()){
				list.add(new ForegroundPeople(
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
						));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��ѯһ��ǰ̨��Ա��Ϣ
	//����
		public List<ForegroundPeople> getOne(String fname){
			String sql="select *from foregroundPeople where fName=?";
			ResultSet set=dbManager.executeQuary(sql,fname);
			List<ForegroundPeople> list=new ArrayList<ForegroundPeople>();
			try {
				while(set.next()){
					list.add(new ForegroundPeople(
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
							));
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	//�õ���ǰҳ��������
		public List<ForegroundPeople> getPageForegroundPeople(int page){
			String sql="select fId,fName,fPassword,fPhone,fSex,fPay,enterTime,endTime,fPage,fSign ,state from" +
					" (select  fId,fName,fPassword,fPhone,fSex,fPay,enterTime,endTime,fPage,fSign ,state ," +
					" rownum rn from foregroundPeople ) where  rn between ? and ?";
			ResultSet rs=dbManager.executeQuary(sql,
					(page-1)*PAGESIZE+1,
					page*PAGESIZE
			);
			List<ForegroundPeople> foregroundPeoples=new ArrayList<ForegroundPeople>();
			try {
				while(rs.next()){
					foregroundPeoples.add(new ForegroundPeople(
							rs.getInt("fId"),
							rs.getString("fName"),
							rs.getString("fPassword"),
							rs.getString("fPhone"),
							rs.getString("fSex"),
							rs.getString("fPay"),
							rs.getDate("enterTime"),
							rs.getDate("endTime"),
							rs.getString("fPage"),
							rs.getInt("fSign"),
							rs.getInt("state")
							));
				}
				return foregroundPeoples;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//�õ�ҳ��
		public long getPageCount() {
			String sql="select count(1) from foregroundPeople";
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
		//�޸�
		public Boolean update(String fPhone,String fPay,String endTime,int state,int fId){
			System.out.println(fPhone);
			System.out.println(fPay);
			System.out.println(endTime);
			System.out.println(state);
			System.out.println(fId);
			String sql="update foregroundPeople set fPhone=?,fPay=?,endTime='"+endTime+"',state=? where fId=?";
			int decide=dbManager.executeUpdate(sql, fPhone,fPay,state,fId);
			if(decide<1){
				return false;
			}else{
				return true;
			}
		}
}

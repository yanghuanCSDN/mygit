package com.yanghuan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yanghuan.dbmanager.DbManager;
import com.yanghuan.model.Coach;
import com.yanghuan.model.Equipment;
/**
 * ������̨����ϵͳ   1.0�汾
 * 2017-11-5~2017-11-10
 * ����
 * @author Administrator
 *
 */
public class EquipmentDao {
	DbManager dbManager=new DbManager();
	private static final long PAGESIZE =  5;
	//��������������������
		public List<Equipment> getOne(String eName){
			String sql="select *from equipment where eName=?";
			ResultSet rs=dbManager.executeQuary(sql,eName);
			List<Equipment> list=new ArrayList<Equipment>();
			try {
				while(rs.next()){
					list.add(new Equipment(
							rs.getInt("eId"),
							rs.getString("eName"),
							rs.getString("eVersion"),
							rs.getInt("registernumber"),
							rs.getString("interfac")
							));
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//�õ���ǰҳ��������
		public List<Equipment> getPageEquipment(int page){
			String sql="select eId,eName,eVersion,registernumber,interfac from" +
					" (select eId,eName,eVersion,registernumber,interfac,rownum rn from equipment )" +
					" where rn between ? and ?";
			ResultSet rs=dbManager.executeQuary(sql,
					(page-1)*PAGESIZE+1,
					page*PAGESIZE
			);
			List<Equipment> equipments=new ArrayList<Equipment>();
			try {
				while(rs.next()){
					equipments.add(new Equipment(
							rs.getInt("eId"),
							rs.getString("eName"),
							rs.getString("eVersion"),
							rs.getInt("registernumber"),
							rs.getString("interfac")
							));
				}
				return equipments;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//�õ�ҳ��
		public long getPageCount() {
			String sql="select count(1) from equipment";
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
}

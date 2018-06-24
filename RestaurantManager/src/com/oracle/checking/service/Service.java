package com.oracle.checking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dao.MenuDao;
import com.oracle.checking.unit.AllFoodMenu;
//�˵�
public class Service {
   MenuDao dao=new MenuDao();
   //����һ�м�¼
   public AllFoodMenu getMenuInfo(int id) throws SQLException{
		return dao.selectAllGood(id);
	}
  //����һҳ��¼����
	public ArrayList<AllFoodMenu> getPageMenuInfo(
			int page, int lines) throws SQLException{
		       return dao.selectPageInfo(page, lines);
	}
  //�����ܼ�¼����
	public int getTotalMenuCount() throws SQLException{
		return dao.allMenuCount();
	}
	//����ɾ��
	public  int delete1(int id) throws SQLException{
		int judge=dao.delete(id);
		return judge;
	}
	//�������  ����һ������
	public int insert1(int id,String name,double price,double discount) throws SQLException{
		int judge=dao.insert(id, name, price, discount);
		return judge;
	}
	//�����޸�
	public int update(double price,int id) throws SQLException{
		int judge1=dao.revise(price, id);
		return judge1;
	}
}

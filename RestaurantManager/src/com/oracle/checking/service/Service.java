package com.oracle.checking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dao.MenuDao;
import com.oracle.checking.unit.AllFoodMenu;
//菜单
public class Service {
   MenuDao dao=new MenuDao();
   //返回一行记录
   public AllFoodMenu getMenuInfo(int id) throws SQLException{
		return dao.selectAllGood(id);
	}
  //返回一页记录集合
	public ArrayList<AllFoodMenu> getPageMenuInfo(
			int page, int lines) throws SQLException{
		       return dao.selectPageInfo(page, lines);
	}
  //返回总记录条数
	public int getTotalMenuCount() throws SQLException{
		return dao.allMenuCount();
	}
	//用于删除
	public  int delete1(int id) throws SQLException{
		int judge=dao.delete(id);
		return judge;
	}
	//用于添加  返回一个对象
	public int insert1(int id,String name,double price,double discount) throws SQLException{
		int judge=dao.insert(id, name, price, discount);
		return judge;
	}
	//用于修改
	public int update(double price,int id) throws SQLException{
		int judge1=dao.revise(price, id);
		return judge1;
	}
}

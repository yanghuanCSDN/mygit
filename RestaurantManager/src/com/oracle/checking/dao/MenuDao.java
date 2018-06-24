package com.oracle.checking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dbmanager.DBManager;
import com.oracle.checking.unit.AllFoodMenu;

//菜单
public class MenuDao {
	//查询menu中的内容
	 private DBManager manager=new DBManager();
	 //查询指定一行的记录
     public AllFoodMenu selectAllGood(int id) throws SQLException{
		String sql="   select * from menu1 where id=?";
		ResultSet set=manager.executeQuery(sql,id);
		//解析结果
      if(set.next()){
	        int mid=set.getInt("id");
        	String name=set.getString("name");
        	Double price=set.getDouble("price");
        	Double discount=set.getDouble("discount");
        	AllFoodMenu t=new AllFoodMenu( mid, name, price, discount);
        	return t;
        }else{
	        return null;
      }
  }
	 //查询一页的记录
	 public ArrayList<AllFoodMenu> selectPageInfo(int page, int lines) throws SQLException{
	   //创建集合
       ArrayList<AllFoodMenu> menu2=new  ArrayList<AllFoodMenu>();
       String sql="select * from menu1 where id between ? and ?";
       ResultSet result=manager.executeQuery(sql,(page-1)*lines+1, page*lines);
       //解析结果
       while(result.next()){
    	  int id2=result.getInt("id");
    	  String name=result.getString("name");
    	  Double price=result.getDouble("price");
    	  Double discount=result.getDouble("discount");
    	  AllFoodMenu t=new AllFoodMenu(id2, name, price, discount);
    	  menu2.add(t);
       }
       return menu2;
	 }
	 //menu中总的记录条数
	 public int allMenuCount() throws SQLException{
		 String sql = "select count(*) c from menu1";
		 ResultSet set = manager.executeQuery(sql);
	     int count1=0;
		   if (set.next())
				count1 = set.getInt(1);
			      return count1;
		  }
	 //删除
	 public int delete(int id) throws SQLException{
		 int judge;
		 String sql="delete from menu1 where id=?";
		 judge=manager.executeUpdate(sql, id);
		 return judge;
	 }
	 //添加,返回一个对象
	 public int insert(int id,String name,double price,double discount) throws SQLException{
		 String sql="insert into menu1 values (?,?,?,?)";
		 int judge=manager.executeUpdate(sql, id,name,price,discount);
		 return  judge;
	}
	 //修改
	 public int revise(double price1,int id1) throws SQLException{
		 String sql="update menu1 set price=? where id=?";
		 int judge=manager.executeUpdate(sql, price1,id1);
	          return judge;
	} 
 }



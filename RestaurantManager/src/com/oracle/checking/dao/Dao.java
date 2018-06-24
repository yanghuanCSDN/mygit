package com.oracle.checking.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dbmanager.DBManager;
import com.oracle.checking.unit.VipBaijiu;
import com.oracle.checking.unit.Pbaijiu;
//�׾�
public class Dao {
	DBManager dbmanager=new DBManager();
//��vip�׾�
public ArrayList<VipBaijiu> vipBaiJiu() throws SQLException {
	ArrayList<VipBaijiu> bguke1 = new ArrayList<VipBaijiu>();
	String sql = "select * from cvip";
	ResultSet set = dbmanager.executeQuery(sql);
    //�������
	while (set.next()) {
		Date shijian=set.getDate("shijian");
		String zhonglei1=set.getString("zhonglei");
		 int danjia=set.getInt("danjia");
		 int nianfen=set.getInt("nianfen");
		double dushu=set.getDouble("dushu");
		 String jianjie=set.getString("jianjie");
		VipBaijiu c2 = new VipBaijiu(shijian,zhonglei1,danjia,nianfen,dushu,jianjie);
		bguke1.add(c2);
	}
	 return bguke1;
}
//�������
public int insert(String shijian, String zhonglei, int danjia, int nianfen,
		double dushu, String jianjie) throws SQLException {
	String sql = "insert into cvip values(?,?,?,?,?,?)";
	int count=dbmanager.executeUpdate(sql, shijian, zhonglei,danjia,nianfen,dushu,jianjie);
	return count;
}


// ��
public void gai(String zhonglei, String zhonglei2) throws SQLException {
	String sql = "update bguke set zhonglei=? where zhonglei2=?";
	dbmanager.executeUpdate(sql, zhonglei, zhonglei2);
}
//ɾ��
public int delete(String zhonglei) throws SQLException {
	String sql = "delete from cvip where zhonglei=? ";
	int count=dbmanager.executeUpdate(sql,  zhonglei);
	return count;
}



//��˿Ͱ׾�
public ArrayList<Pbaijiu> Pbaijiu() throws SQLException {
	ArrayList<Pbaijiu> cguke1 = new ArrayList<Pbaijiu>();
	String sql = "select * from cguke";
	ResultSet set = dbmanager.executeQuery(sql);
	//�������
		while (set.next()) {
		String zhonglei1=set.getString("zhonglei");
			 int danjia=set.getInt("danjia");
			 int nianfen=set.getInt("nianfen");
			double dushu=set.getDouble("dushu");
			 String jianjie=set.getString("jianjie");
			 Pbaijiu c3 = new Pbaijiu(zhonglei1,danjia,nianfen,dushu,jianjie);
			cguke1.add(c3);
		}
		 return cguke1;
	}
//�������
public int insert2(String zhonglei, int danjia, int nianfen,
	double dushu, String jianjie) throws SQLException {
	String sql = "insert into cguke values(?,?,?,?,?)";
	int count=dbmanager.executeUpdate(sql,zhonglei,danjia,nianfen,dushu,jianjie);
	return count;
}
//ɾ��
public int delete1(String zhonglei) throws SQLException {
	String sql = "delete from cguke where zhonglei=? ";
	int count=dbmanager.executeUpdate(sql,  zhonglei);
	return count;
}
}

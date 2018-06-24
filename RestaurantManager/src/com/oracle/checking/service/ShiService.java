package com.oracle.checking.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dao.Dao;
import com.oracle.checking.unit.VipBaijiu;
import com.oracle.checking.unit.Pbaijiu;
//白酒
//接受集合
public class ShiService {
	//创建Dao对象
	//得到vip白酒的集合
	Dao dao=new Dao();
	public ArrayList<VipBaijiu>  vipBaiJiu1() throws SQLException{
		return dao.vipBaiJiu();
	}
	//用于添加数据
	public int insert1(String shijian, String zhonglei, int danjia, int nianfen,
			double dushu, String jianjie) throws SQLException{
		return dao.insert(shijian, zhonglei, danjia, nianfen, dushu, jianjie);
	}
	//用于删除数据
		public int delete1(String zhonglei) throws SQLException{
			return dao.delete(zhonglei);
		}
		
		
		
		
		//得到顾客白酒的集合
	public ArrayList<Pbaijiu>  Pbaijiu() throws SQLException{
			return dao.Pbaijiu();
		}
		//用于添加数据
		public int insert2(String zhonglei, int danjia, int nianfen,
				double dushu, String jianjie) throws SQLException{
			return dao.insert2(zhonglei, danjia, nianfen, dushu, jianjie);
		}
		//用于删除数据
			public int delete2(String zhonglei) throws SQLException{
				return dao.delete1(zhonglei);
			}
}


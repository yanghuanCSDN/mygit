package com.oracle.checking.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.oracle.checking.dao.Dao;
import com.oracle.checking.unit.VipBaijiu;
import com.oracle.checking.unit.Pbaijiu;
//�׾�
//���ܼ���
public class ShiService {
	//����Dao����
	//�õ�vip�׾Ƶļ���
	Dao dao=new Dao();
	public ArrayList<VipBaijiu>  vipBaiJiu1() throws SQLException{
		return dao.vipBaiJiu();
	}
	//�����������
	public int insert1(String shijian, String zhonglei, int danjia, int nianfen,
			double dushu, String jianjie) throws SQLException{
		return dao.insert(shijian, zhonglei, danjia, nianfen, dushu, jianjie);
	}
	//����ɾ������
		public int delete1(String zhonglei) throws SQLException{
			return dao.delete(zhonglei);
		}
		
		
		
		
		//�õ��˿Ͱ׾Ƶļ���
	public ArrayList<Pbaijiu>  Pbaijiu() throws SQLException{
			return dao.Pbaijiu();
		}
		//�����������
		public int insert2(String zhonglei, int danjia, int nianfen,
				double dushu, String jianjie) throws SQLException{
			return dao.insert2(zhonglei, danjia, nianfen, dushu, jianjie);
		}
		//����ɾ������
			public int delete2(String zhonglei) throws SQLException{
				return dao.delete1(zhonglei);
			}
}


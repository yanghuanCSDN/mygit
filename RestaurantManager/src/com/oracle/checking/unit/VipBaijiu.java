package com.oracle.checking.unit;

import java.sql.Date;
//VIP°×¾Æ
public class VipBaijiu {
	private Date shijian;
	private String zhonglei;
	private int danjia;
	private int nianfen;
	private double dushu;
	private String jianjie;

	public Date getShijian() {
		return shijian;
	}

	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}

	public String getZhonglei() {
		return zhonglei;
	}

	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}

	public int getDanjia() {
		return danjia;
	}

	public void setDanjia(int danjia) {
		this.danjia = danjia;
	}

	public int getNianfen() {
		return nianfen;
	}

	public void setNianfen(int nianfen) {
		this.nianfen = nianfen;
	}

	public double getDushu() {
		return dushu;
	}

	public void setDushu(double dushu) {
		this.dushu = dushu;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public VipBaijiu(Date shijian, String zhonglei, int danjia, int nianfen,
			double dushu, String jianjie) {
		super();
		this.shijian = shijian;
		this.zhonglei = zhonglei;
		this.danjia = danjia;
		this.nianfen = nianfen;
		this.dushu = dushu;
		this.jianjie = jianjie;
	}

	public VipBaijiu() {
	}
}
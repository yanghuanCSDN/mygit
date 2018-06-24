package com.oracle.checking.unit;

//一般顾客的饮料
public class YinLiao {
private String zhonglei;
private String rongliang;
private String danjia;
public YinLiao(String zhonglei, String rongliang, String danjia) {
	this.zhonglei = zhonglei;
	this.rongliang = rongliang;
	this.danjia = danjia;
}
  public String getZhonglei() {
	  return zhonglei;
 }

  public String getRongliang() {
	   return rongliang;
 }

  public String getDanjia() {
	    return danjia;
  }
   public YinLiao(){}
}


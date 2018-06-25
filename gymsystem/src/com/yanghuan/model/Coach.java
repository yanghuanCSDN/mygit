package com.yanghuan.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 教练
 * @author Administrator
 *
 */
public class Coach implements Serializable{
	private int cId;      		//教练id
	private String cName;		//教练姓名
	private String cIdcard;		//教练身份证号
	private String cPassword;	//教练登录密码
	private String cPhone;		//教练手机号码
	private String cSex;		//教练性别
	private String cPay;		//教练工资
	private String cJobkind;	//工作属性
	private Date entryTime;		//教练入职时间
	private Date endTime;		//教练离职时间
	private int registerSign;	//教练签到标签
	private String cPage;		//教练照片
	private int state;			//1就职/0离职 
	public Coach() {
		super();
	}
	public Coach(int cId, String cName, String cIdcard, String cPassword,
			String cPhone, String cSex, String cPay, String cJobkind,
			Date entryTime, Date endTime, int registerSign, String cPage,
			int state) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cIdcard = cIdcard;
		this.cPassword = cPassword;
		this.cPhone = cPhone;
		this.cSex = cSex;
		this.cPay = cPay;
		this.cJobkind = cJobkind;
		this.entryTime = entryTime;
		this.endTime = endTime;
		this.registerSign = registerSign;
		this.cPage = cPage;
		this.state = state;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coach other = (Coach) obj;
		if (cId != other.cId)
			return false;
		return true;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcIdcard() {
		return cIdcard;
	}
	public void setcIdcard(String cIdcard) {
		this.cIdcard = cIdcard;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcSex() {
		return cSex;
	}
	public void setcSex(String cSex) {
		this.cSex = cSex;
	}
	public String getcPay() {
		return cPay;
	}
	public void setcPay(String cPay) {
		this.cPay = cPay;
	}
	public String getcJobkind() {
		return cJobkind;
	}
	public void setcJobkind(String cJobkind) {
		this.cJobkind = cJobkind;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getRegisterSign() {
		return registerSign;
	}
	public void setRegisterSign(int registerSign) {
		this.registerSign = registerSign;
	}
	public String getcPage() {
		return cPage;
	}
	public void setcPage(String cPage) {
		this.cPage = cPage;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String toString() {
		return "Coach [cId=" + cId + ", cName=" + cName + ", cIdcard="
				+ cIdcard + ", cPassword=" + cPassword + ", cPhone=" + cPhone
				+ ", cSex=" + cSex + ", cPay=" + cPay + ", cJobkind="
				+ cJobkind + ", entryTime=" + entryTime + ", endTime="
				+ endTime + ", registerSign=" + registerSign + ", cPage="
				+ cPage + ", state=" + state + "]";
	}
}

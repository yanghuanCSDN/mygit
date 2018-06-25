package com.yanghuan.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 前台人员
 * @author Administrator
 *
 */
public class ForegroundPeople implements Serializable{
	private int  fId;
	private String fName;
	private String fPassword;
	private String fPhone;
	private String fSex;
	private String fPay;
	private Date enterTime;
	private Date endTime;
	private String fPage;
	private int fSign;
	private int state;
	public ForegroundPeople() {
		super();
	}
	public ForegroundPeople(int fId, String fName, String fPassword,
			String fPhone, String fSex, String fPay, Date enterTime,
			Date endTime, String fPage, int fSign, int state) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.fPassword = fPassword;
		this.fPhone = fPhone;
		this.fSex = fSex;
		this.fPay = fPay;
		this.enterTime = enterTime;
		this.endTime = endTime;
		this.fPage = fPage;
		this.fSign = fSign;
		this.state = state;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fId;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ForegroundPeople other = (ForegroundPeople) obj;
		if (fId != other.fId)
			return false;
		return true;
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfPassword() {
		return fPassword;
	}
	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}
	public String getfPhone() {
		return fPhone;
	}
	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	public String getfSex() {
		return fSex;
	}
	public void setfSex(String fSex) {
		this.fSex = fSex;
	}
	public String getfPay() {
		return fPay;
	}
	public void setfPay(String fPay) {
		this.fPay = fPay;
	}
	public Date getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getfPage() {
		return fPage;
	}
	public void setfPage(String fPage) {
		this.fPage = fPage;
	}
	public int getfSign() {
		return fSign;
	}
	public void setfSign(int fSign) {
		this.fSign = fSign;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String toString() {
		return "ForegroundPeople [fId=" + fId + ", fName=" + fName
				+ ", fPassword=" + fPassword + ", fPhone=" + fPhone + ", fSex="
				+ fSex + ", fPay=" + fPay + ", enterTime=" + enterTime
				+ ", endTime=" + endTime + ", fPage=" + fPage + ", fSign="
				+ fSign + ", state=" + state + "]";
	}
}

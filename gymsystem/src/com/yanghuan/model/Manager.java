package com.yanghuan.model;

import java.io.Serializable;

/**
 * ������̨����ϵͳ   1.0�汾 
 * 2017-11-5~2017-11-10
 * ����Ա
 * @author Administrator
 *
 */
public class Manager implements Serializable{
	private int mId;         //����Աid
	private String mName;    //����Ա����
	private String mPassword;//����Ա����
	private String mIdCard;  //����Ա���֤
	private String mPhone;   //����Ա�ֻ�����
	private String mSex;     //����Ա�Ա�
	private String mPage;    //����Ա��Ƭ
	public Manager() {
		super();
	}
	public Manager(int mId, String mName, String mPassword, String mIdCard,
			String mPhone, String mSex, String mPage) {
		super();
		this.mId = mId;
		this.mName = mName;
		this.mPassword = mPassword;
		this.mIdCard = mIdCard;
		this.mPhone = mPhone;
		this.mSex = mSex;
		this.mPage = mPage;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mId;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (mId != other.mId)
			return false;
		return true;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmIdCard() {
		return mIdCard;
	}
	public void setmIdCard(String mIdCard) {
		this.mIdCard = mIdCard;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmSex() {
		return mSex;
	}
	public void setmSex(String mSex) {
		this.mSex = mSex;
	}
	public String getmPage() {
		return mPage;
	}
	public void setmPage(String mPage) {
		this.mPage = mPage;
	}
	public String toString() {
		return "Manager [mId=" + mId + ", mName=" + mName + ", mPassword="
				+ mPassword + ", mIdCard=" + mIdCard + ", mPhone=" + mPhone
				+ ", mSex=" + mSex + ", mPage=" + mPage + "]";
	}
}

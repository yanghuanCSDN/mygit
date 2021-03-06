package com.yanghuan.model;
import java.sql.Date;
public class User {
	private int personId;
	private String QQNumber;
	private String personSignature;
	private String realName;
	private String idCard;
	private String cellPhoneNumber;
	private int judgeOpened;
	private Date submissionTime;
	public User() {
		super();
	}
	public User(int personId, String qQNumber, String personSignature,
			String realName, String idCard, String cellPhoneNumber,
			int judgeOpened, Date submissionTime) {
		super();
		this.personId = personId;
		this.QQNumber = qQNumber;
		this.personSignature = personSignature;
		this.realName = realName;
		this.idCard = idCard;
		this.cellPhoneNumber = cellPhoneNumber;
		this.judgeOpened = judgeOpened;
		this.submissionTime = submissionTime;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idCard == null) {
			if (other.idCard != null)
				return false;
		} else if (!idCard.equals(other.idCard))
			return false;
		return true;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getQQNumber() {
		return QQNumber;
	}
	public void setQQNumber(String qQNumber) {
		this.QQNumber = qQNumber;
	}
	public String getPersonSignature() {
		return personSignature;
	}
	public void setPersonSignature(String personSignature) {
		this.personSignature = personSignature;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public int getJudgeOpened() {
		return judgeOpened;
	}
	public void setJudgeOpened(int judgeOpened) {
		this.judgeOpened = judgeOpened;
	}
	public Date getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}
}

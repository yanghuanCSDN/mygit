package com.yanghuan.model;

import java.io.Serializable;
import java.sql.Date;
/**
 * ������̨����ϵͳ   1.0�汾 
 * 2017-11-5~2017-11-10
 * �˿�
 * @author Administrator
 *
 */
public class Consumer implements Serializable{
	private int coId; 				//�û�id
	private String coName;			//�û�����
	private String coSex;			//�û��Ա�
	private String coIdCard;		//�û����֤����
	private String coPhone;			//�绰����
	private String memberShipCard;	//��Ա����
	private String member_adviser;	//����˻�Ա��ǰ̨
	private String coachName;		//����˻�Ա�Ľ���
	private int fName;				//ǩ����¼
	private int equipmentNumber;	//ʹ�����ļ�¼
	private int sendMoney;			//��������
	private int state;				//1Ϊvip�� 0Ϊ��ͨ
	private String course;			//�Ƽ��γ�
	private Date firstTime;			//����ʱ��
	private Date endTime;			//����ʱ��
	private String page;			//�û���Ƭ
	public Consumer() {
		super();
	}
	public Consumer(int coId, String coName, String coSex, /*String coIdCard,*/
			String coPhone, String memberShipCard, String member_adviser,
			String coachName, int fName, int equipmentNumber, int sendMoney,
			int state, String course, Date firstTime, Date endTime, String page) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coSex = coSex;
		/*this.coIdCard = coIdCard;*/
		this.coPhone = coPhone;
		this.memberShipCard = memberShipCard;
		this.member_adviser = member_adviser;
		this.coachName = coachName;
		this.fName = fName;
		this.equipmentNumber = equipmentNumber;
		this.sendMoney = sendMoney;
		this.state = state;
		this.course = course;
		this.firstTime = firstTime;
		this.endTime = endTime;
		this.page = page;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coId;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumer other = (Consumer) obj;
		if (coId != other.coId)
			return false;
		return true;
	}
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoSex() {
		return coSex;
	}
	public void setCoSex(String coSex) {
		this.coSex = coSex;
	}
	public String getCoIdCard() {
		return coIdCard;
	}
	public void setCoIdCard(String coIdCard) {
		this.coIdCard = coIdCard;
	}
	public String getCoPhone() {
		return coPhone;
	}
	public void setCoPhone(String coPhone) {
		this.coPhone = coPhone;
	}
	public String getMemberShipCard() {
		return memberShipCard;
	}
	public void setMemberShipCard(String memberShipCard) {
		this.memberShipCard = memberShipCard;
	}
	public String getMember_adviser() {
		return member_adviser;
	}
	public void setMember_adviser(String member_adviser) {
		this.member_adviser = member_adviser;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public int getfName() {
		return fName;
	}
	public void setfName(int fName) {
		this.fName = fName;
	}
	public int getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(int equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public int getSendMoney() {
		return sendMoney;
	}
	public void setSendMoney(int sendMoney) {
		this.sendMoney = sendMoney;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Date getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String toString() {
		return "Consumer [coId=" + coId + ", coName=" + coName + ", coSex="
				+ coSex + ", coIdCard=" + coIdCard + ", coPhone=" + coPhone
				+ ", memberShipCard=" + memberShipCard + ", member_adviser="
				+ member_adviser + ", coachName=" + coachName + ", fName="
				+ fName + ", equipmentNumber=" + equipmentNumber
				+ ", sendMoney=" + sendMoney + ", state=" + state + ", course="
				+ course + ", firstTime=" + firstTime + ", endTime=" + endTime
				+ ", page=" + page + "]";
	}
}

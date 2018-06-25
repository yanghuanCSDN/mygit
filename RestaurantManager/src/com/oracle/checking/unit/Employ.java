package com.oracle.checking.unit;

import java.sql.Date;

public class Employ {
	private int eid;
	private String ename;
	private int eage;
	private String esex;
	private String eaddress;
	private Date ehiredate;
	private int esal;
	
	public Employ(int eid,String ename,int eage,String esex,
			String eaddress,Date ehiredate,int esal){
		this.eid = eid;
		this.ename = ename;
		this.eage = eage;
		this.esex = esex;
		this.eaddress = eaddress;
		this.ehiredate = ehiredate;
		this.esal = esal;
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public Date getEhiredate() {
		return ehiredate;
	}
	public void setEhiredate(Date ehiredate) {
		this.ehiredate = ehiredate;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
}


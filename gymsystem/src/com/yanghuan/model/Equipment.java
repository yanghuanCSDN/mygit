package com.yanghuan.model;

import java.io.Serializable;

/**
 * 健身房后台管理系统   1.0版本 
 * 2017-11-5~2017-11-10
 * 器材
 * @author Administrator
 *
 */
public class Equipment implements Serializable{
	private int eId;			//器材id
	private String eName;		//器材名称
	private String eVersion;	//器材型号
	private int registernumber; //器材标记号
	private String interfac;	//摄像头标志
	public Equipment() {
		super();
	}
	public Equipment(int eId, String eName, String eVersion,
			int registernumber, String interfac) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eVersion = eVersion;
		this.registernumber = registernumber;
		this.interfac = interfac;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eId;
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (eId != other.eId)
			return false;
		return true;
	}
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteVersion() {
		return eVersion;
	}
	public void seteVersion(String eVersion) {
		this.eVersion = eVersion;
	}
	public int getRegisternumber() {
		return registernumber;
	}
	public void setRegisternumber(int registernumber) {
		this.registernumber = registernumber;
	}
	public String getInterfac() {
		return interfac;
	}
	public void setInterfac(String interfac) {
		this.interfac = interfac;
	}
	public String toString() {
		return "Equipment [eId=" + eId + ", eName=" + eName + ", eVersion="
				+ eVersion + ", registernumber=" + registernumber
				+ ", interfac=" + interfac + "]";
	}
}

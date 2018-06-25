package com.oracle.checking.unit;

import java.util.Date;
//ÆÕÍ¨¹Ë¿Í
public class Client {
	private int clientid;
	private int clientpwd;
	private String clientname;
	private Date clientbirthday;
	private int clientgrade;
	private String clientkind;
    public Client(int clientid, int clientpwd, String clientname,
			Date clientbirthday, int clientgrade,String clientkind) {
		this.clientid = clientid;
		this.clientpwd = clientpwd;
		this.clientname = clientname;
		this.clientbirthday = clientbirthday;
		this.clientgrade = clientgrade;
		this.clientkind = clientkind;
		
	}

	public int getClientid() {
		return clientid;
	}

	public int getClientpwd() {
		return clientpwd;
	}

	public String getClientname() {
		return clientname;
	}

	public Date getClientbirthday() {
		return clientbirthday;
	}

	public int getClientgrade() {
		return clientgrade;
	}
	public String getClientkind() {
		return clientkind;
	}

}


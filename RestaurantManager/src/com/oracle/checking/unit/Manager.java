package com.oracle.checking.unit;
//Boss
public class Manager {
    private int id;
    private String name;
    private String pwd;
    public int getId() {
		return id;
	}
    public String getName() {
		return name;
	}
    public String getPwd() {
		return pwd;
	}
   public Manager(int id,String name,String pwd){
    	this.id=id;
    	this.name=name;
    	this.pwd=pwd;
    }
}

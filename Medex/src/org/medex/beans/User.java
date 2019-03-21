package org.medex.beans;

public class User {
	private String id;
	private String pwd;
	private String role;
	private String name;
	
	public User() {
		super();
	}
	
	

	public User(String id, String pwd, String role, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

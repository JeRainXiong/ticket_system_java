package com.whut.entity;

public class User{
    private int userId;
    private String username;
    private String password;
    private String userRealname;
    private String userIdCard;
    private String tel;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRealname() {
		return userRealname;
	}
	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public User(int userId, String username, String password, String userRealname, String userIdCard, String tel) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userRealname = userRealname;
		this.userIdCard = userIdCard;
		this.tel = tel;
	}
    
    public User() {}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userRealname="
				+ userRealname + ", userIdCard=" + userIdCard + ", tel=" + tel + "]";
	}
    
}
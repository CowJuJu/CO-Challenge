package com.co.transactions.domain.Login;

public class LoginResponse {

	private int uid;
	private String token;
	
	public LoginResponse(int uid, String token){
		this.uid = uid;
		this.token = token;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}

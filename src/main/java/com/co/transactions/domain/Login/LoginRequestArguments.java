package com.co.transactions.domain.Login;

public class LoginRequestArguments {
	
	private int uid;
	private String token;
	private String apitoken;
	private boolean jsonModel;
	private boolean jsonResponse;
	
	public LoginRequestArguments(int uid, String token, boolean jsonModel, boolean jsonResponse){
		this.uid = uid;
		this.token = token;
		this.jsonModel = jsonModel;
		this.jsonResponse = jsonResponse;
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
	public String getApitoken() {
		return apitoken;
	}
	public void setApitoken(String apitoken) {
		this.apitoken = apitoken;
	}
	public boolean getJsonModel() {
		return jsonModel;
	}
	public void setJsonModel(boolean jsonModel) {
		this.jsonModel = jsonModel;
	}
	public boolean getJsonResponse() {
		return jsonResponse;
	}
	public void setJsonResponse(boolean jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

}

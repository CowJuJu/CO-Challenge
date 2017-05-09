package com.co.transactions.domain.Login;

public class LoginRequest {
	
	private String email;
	private String password;
	private LoginRequestArguments loginRequestArguments;
	private String accountType;
	
	
	public LoginRequest(String email, String password, LoginRequestArguments loginRequestArguments, String accountType){
		this.email = email;
		this.password = password;
		this.loginRequestArguments = getLoginRequestArguments();
		this.accountType = accountType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginRequestArguments getLoginRequestArguments() {
		return loginRequestArguments;
	}

	public void setLoginRequestArguments(LoginRequestArguments loginRequestArguments) {
		this.loginRequestArguments = loginRequestArguments;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}

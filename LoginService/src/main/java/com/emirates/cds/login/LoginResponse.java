/**
 * 
 */
package com.emirates.cds.login;

/**
 * @author Vinod
 *
 */
public class LoginResponse {
	
	private String code;
	private String message;
	private String token;
		
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	

}

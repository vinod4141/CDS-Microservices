package com.emirates.cds.login;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.cds.login.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {

	@CrossOrigin
	@RequestMapping(value ="/", method=RequestMethod.HEAD)
	@ResponseStatus(HttpStatus.OK)
	public void health(){
		
	}
	@CrossOrigin
	@RequestMapping(value ="/", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String getHealth(){
		return ("Success");
	}
	@CrossOrigin
	@RequestMapping("/login")
	public LoginResponse login (@RequestParam(value="name") String name, 
								@RequestParam(value="password") String password){
		
		System.out.println("Reached Login Service");
		LoginResponse loginResponse = new LoginResponse();
		LoginService service = new LoginService();
		
		if (name != null && password != null){
			System.out.println("UserName Recived is " + name);
			//System.out.println("Pass Recived is " + password);
			if( service.verifyLogin(name, password)){
				loginResponse.setCode("0");
				loginResponse.setMessage("Success");
				loginResponse.setToken("dist0001");
			} else {
				loginResponse.setCode("1");
				loginResponse.setMessage("User Name or Password is wrong");
			}
		} else {
			loginResponse.setCode("1");
			loginResponse.setMessage("User Name or Password cannot be empty");
		}
		System.out.println("Value Returned is " + loginResponse.getMessage());
		return loginResponse;
		
	}
	
	
	
}
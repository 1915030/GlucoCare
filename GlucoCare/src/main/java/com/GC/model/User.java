package com.GC.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class User {
	
	public String _id;
	public String name;
	public String email;
	public String password;
	
	public User() {
		
	}

	
	public User(String name, String password,String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.length()<2) {
			System.out.println("Invalid Name");
		}else {
			this.name = name;
			System.out.println("Name Set");
		}
		
		
	}
	
public void makePasswordSecure() {
		
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(password.getBytes());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}


	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("password", password);
		map.put("email", email);
		return map;
	}


	@Override
	public String toString() {
		return "User [_id=" + _id + ", name=" + name + ", password=" + password + ", email=" + email + "]"
				+"\n"+super.toString();
	}


}
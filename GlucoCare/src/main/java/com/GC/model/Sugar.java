package com.GC.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Sugar {
	
	public String _id;
	public String userId;
	public double sugar;
	public String dateTimeStamp;
	
	public Sugar() {
		
	}
	
	Sugar(String userId, double sugar, String dateTimeStamp) {
		this.userId = userId;
		this.sugar = sugar;
		this.dateTimeStamp = dateTimeStamp;
	}

	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("sugarLvl", sugar);
		map.put("dateTimeStamp", new Date());
		return map;
	}
 

	@Override
	public String toString() {
		return "SugarLvl [_id=" + _id + ", userId=" + userId + ", sugar=" + sugar + "]";
	}

}
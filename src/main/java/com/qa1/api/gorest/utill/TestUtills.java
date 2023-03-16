package com.qa1.api.gorest.utill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtills {
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	
	public static String getSerializeJson(Object obj) {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonPayload = null;
		
		
		try {
			jsonPayload = mapper.writeValueAsString(obj);
			System.out.println("JSON body payload :=======>  "+jsonPayload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonPayload;
	}
	
	

}

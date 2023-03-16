package com.qa1.api.gorest.utill;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class Token {

	private static Map<String,String> getMultiAuth;
	private static Map<String,String> tokenMap = new HashMap<String,String>();
	private static String clientId = "66f4918ab1b4d24";
	
	public static Map<String, String>  getAcessToken() {

		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "39a17fdfc1fd914d2a9651aa74c8a4013044ab01");
		formParams.put("client_id", "66f4918ab1b4d24");
		formParams.put("client_secret", "3d45304d1fba70f9f67bc28993ed6e6c36f2f32f");
		formParams.put("grant_type", "refresh_token");

		JsonPath jsonpath = given().formParams(formParams).when().post("https://api.imgur.com/oauth2/token").then()
				.extract().jsonPath();
		System.out.println(jsonpath.getMap(""));
		getMultiAuth = jsonpath.getMap("/RestAssuredAutomationAPI/src/main/java/com/qa1/api/gorest/testdata/IMG_20230101_153340.jpg");
		return getMultiAuth;
		
	}
	
	
	
	public static Map<String,String> getAppToken() {
		String authToken = getMultiAuth.get("access_token").toString();
		System.out.println("Auth token :=====>   "+ authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
		
	}
	
	public static Map<String,String> getClientID() {
		System.out.println("client id :=====>   "+ clientId);
		tokenMap.put("Authorization", "client_id "+clientId);
		return tokenMap;
		
	}

}

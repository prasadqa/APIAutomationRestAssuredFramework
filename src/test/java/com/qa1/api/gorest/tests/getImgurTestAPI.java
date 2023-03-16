package com.qa1.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa1.api.gorest.restClient.RestClient;
import com.qa1.api.gorest.utill.Token;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

@Epic("This is imgur site QAT- 4354")
@Feature("authontication is not working")
public class getImgurTestAPI {
	
	Map<String, String> tokenMap;
	String accessToken;
	String accountUserName;
	String refreshToken;
	
	@BeforeMethod
	public void getToken() {
		tokenMap = Token.getAcessToken();
		
		accessToken = tokenMap.get("access_token").toString();
		accountUserName = tokenMap.get("account_username").toString();
		refreshToken = tokenMap.get("refresh_token").toString();
		
	}
	
	@Description("it gives accunt status")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void getAccountBlackStatusTest() {
		Map<String,String> authToken = Token.getAppToken();
		Response response = RestClient.getCall("https://api.imgur.com", "/account/v1/" + accountUserName + "/block", null, authToken, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
	@Description("it gives count of images")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void getCountOfImageTest() {
		Map<String,String> authToken = Token.getAppToken();
		Response response = RestClient.getCall("https://api.imgur.com", "/3/account/me/images", null, authToken, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
	@Description("it will upload the image")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void postUpLoadImageTest() {
		Map<String,String> authToken = Token.getAppToken();
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "test title API");
		formMap.put("description", "test description API");
		Response response = RestClient.postCall("https://api.imgur.com", "/3/image", "multipart", authToken, null, true,formMap);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
	
	
	
	
	

}

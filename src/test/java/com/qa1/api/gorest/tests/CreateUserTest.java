package com.qa1.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa1.api.gorest.pojo.User;
import com.qa1.api.gorest.restClient.RestClient;
import com.qa1.api.gorest.utill.ExcelUtills;
import com.qa1.api.gorest.utill.Token;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;


@Epic("API Testing QAT-4383")
@Feature("Create User API")

public class CreateUserTest {
	
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = "18b814df0f529895867c216216110d862e8107f0ba6487add24f76904410a952";
	
	@DataProvider
	public Object[][] getUserData() {
		
		 Object testData[][] = ExcelUtills.getTestData("userData");
		 return testData;
		
	}
	
	@Description("it will create user with give parameters")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getUserData" )
	public void createUserTest(String id,String name,String email,String gender,String status) {
		
//		User user = new User(888662,"Deepesh Bhattacharya","bhattacharya_deepesh125@harris.net","female","active");
		User user = new User(id,name,email,gender,status);
		Map<String,String> authToken = new HashMap<String,String>();
		authToken.put("Authorization", "Bearer "+token);
		Response responce =  RestClient.postCall(baseURI, basePath, "JSON", authToken, null, true, user);
		
		System.out.println(responce.statusCode());
		System.out.println(responce.prettyPrint());
		
	}

	@Description("create user only one")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void createUserTest() {
		Map<String,String> authToken = new HashMap<String,String>();
		authToken.put("Authorization", "Bearer "+token);
		
		User user = new User("888662","Deepesh Bhattacharya","bhattacharya_deepesh125@harris.net","female","active");
//		User user = new User(id,name,email,gender,status);
		Response responce =  RestClient.postCall(baseURI, basePath, "JSON", authToken, null, true, user);
		
		System.out.println(responce.statusCode());
		System.out.println(responce.prettyPrint());
		
	}

}

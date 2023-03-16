package com.qa1.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa1.api.gorest.restClient.RestClient;
import com.qa1.api.gorest.utill.Token;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
@Epic("This is imgur site QAT-2345")
@Feature("go rest api give verify the users")
public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public/v2/users";
	String token = "18b814df0f529895867c216216110d862e8107f0ba6487add24f76904410a952";

	@Description("gives all users")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void getAllUserTest() {
		Map<String,String> authToken = new HashMap<String,String>();
		authToken.put("Authorization", "Bearer "+token);
		Response responce = RestClient.getCall(baseURI, basePath, "JSON", authToken, null, true);
		System.out.println(responce.statusCode());
		System.out.println(responce.prettyPrint());

	}
	@Description("QueryParam test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void getCallQueryParamTest() {

		Map<String, String> params = new HashMap<String, String>();
//		params.put("name", "Aruna Shukla");
		params.put("gender", "female");
		Map<String,String> authToken = new HashMap<String,String>();
		authToken.put("Authorization", "Bearer "+token);
		Response responce = RestClient.getCall(baseURI, basePath, "JSON", authToken, params, true);
		System.out.println(responce.statusCode());
		System.out.println(responce.prettyPrint());

	}

}

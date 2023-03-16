package com.qa1.api.gorest.restClient;

import java.io.File;
import java.util.Map;

import com.qa1.api.gorest.utill.TestUtills;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * 
 * we have to most generic methods for http methods like get post put delete calls
 * 
 * 
 * 
 * 
 * */

public class RestClient {
	
	/**
	 * 
	 * @param baseURI
	 * @param basePath
	 * @param contentType
	 * @param token
	 * @param params
	 * @param logs
	 * @return this will give the get call responce 
	 */

	public static Response getCall(String baseURI, String basePath, String contentType, Map<String,String> token,
			Map<String, String> params, boolean logs) {
		if(createBaseURI(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, params, logs);
			return sendRequest("GET", request, basePath);
		}
		return null;

	}
	
	@Step()
	public static Response postCall(String baseURI, String basePath, String contentType, Map<String,String> token,
			Map<String, String> params, boolean logs , Object obj) {
		if(createBaseURI(baseURI)) {
			RequestSpecification request = createRequest(contentType, token, params, logs);
			addPayloadToRequest(request,obj);
			return sendRequest("POST", request, basePath);
		}
		return null;

	}
	
	private static void addPayloadToRequest(RequestSpecification request,Object obj) {
		if(obj instanceof Map) {
			request.formParams((Map<String,String>)obj);
		}else {
		String jsonPayload = TestUtills.getSerializeJson(obj);
		request.body(jsonPayload);
		}
	}
	
	private static boolean createBaseURI(String baseURI) {
		
		if((baseURI==null||baseURI.isEmpty())) {
			System.out.println("Pass the currect uri or it is null/empty ");
			return false;
		}
		
		try {
			RestAssured.baseURI = baseURI;
			return true;
		}catch (Exception e) {
			System.out.println("some exception got occured while accessing URI");
			return false;
		}
		
		

	}

	private static RequestSpecification createRequest(String contentType, Map<String, String> token, Map<String, String> params,
			boolean logs) {

		RequestSpecification request = null;
		if (logs) {
			request = RestAssured.given().log().all();

		} else {
			request = RestAssured.given();
		}

		if (contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		} else if (contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		} else if (contentType.equalsIgnoreCase("TEXT")) {
			request.contentType(ContentType.TEXT);
		}else if (contentType.equalsIgnoreCase("multipart")) {
			request.multiPart("image", new File(""));
		}
		
		

		if (token.size()>0) {
			request.headers(token);
		}

		if (!(params == null)) {
			request.params(params);
		}

		return request;

	}

	private static Response sendRequest(String HTTPmethod, RequestSpecification request, String basePath) {
		return executeRequest(HTTPmethod, request, basePath);
	}

	private static Response executeRequest(String HTTPmethod, RequestSpecification request, String basePath) {

		Response responce = null;

		switch (HTTPmethod) {
		case "GET":
			responce = request.get(basePath);
			break;
		case "POST":
			responce = request.get(basePath);
			break;
		case "PUT":
			responce = request.get(basePath);
			break;
		case "DELETE":
			responce = request.get(basePath);
			break;
		default:
			System.out.println("Please pass the correct HTTP method");
		}

		return responce;

	}

}

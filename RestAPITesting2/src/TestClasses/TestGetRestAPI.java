package TestClasses;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.HandleRequestReponse;
import requestHandling.RestClientHandler;

public class TestGetRestAPI {

	//@Test
	public void TestAllusers() throws Exception  {

		String GETAllusres = HandleRequestReponse.sendGetRequest(URLs.Allusers);
	
		assertTrue("Data is empty", !GETAllusres.equals(""));	
	}
	


	
	//@Test
	public void TestGETuser() throws Exception  {
		
		String Getuser = HandleRequestReponse.sendGetRequest(URLs.specificuser);
		
		assertTrue("Data is empty", !Getuser.equals(""));
		
	}	
	
	@Test 
	public void TestUserNotFound() throws Exception {
		String url = URLs.ReqResAPI+"/50";
		HttpURLConnection connection = RestClientHandler.connectServer(url, HTTPMethod.GET,HTTPRequestsContentTypes.JSON);		
		System.out.println("connection.getResponseCode() : " + connection.getResponseCode());
		assertTrue(connection.getResponseCode() == 404);
		
		}
}



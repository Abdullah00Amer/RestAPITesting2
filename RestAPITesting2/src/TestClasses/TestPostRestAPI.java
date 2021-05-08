package TestClasses;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import Links.FilesPaths;
import Links.URLs;
import Utils.JSONUtils;
import enums.HTTPMethod;
import enums.HTTPRequestsContentTypes;
import requestHandling.RestClientHandler;

public class TestPostRestAPI {

	@Test
	public void testCreatUsers() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.CreatUser, HTTPMethod.POST,
				HTTPRequestsContentTypes.JSON);
		String resquestCreatUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.CreateUser);
		RestClientHandler.sendPost(connection, resquestCreatUsers, HTTPRequestsContentTypes.JSON);
		String CreatUsersresponse = RestClientHandler.readResponse(connection);
		assertTrue("Data is empty", !CreatUsersresponse.equals(""));
	}
	
}

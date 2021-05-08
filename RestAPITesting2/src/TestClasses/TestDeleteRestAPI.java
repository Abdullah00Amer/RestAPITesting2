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

public class TestDeleteRestAPI {
	
	@Test
	public void testDeleteAllusers() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.DeleteAllusers, HTTPMethod.DELETE,
				HTTPRequestsContentTypes.JSON);
		String  DeleteAll = JSONUtils.readJSONObjectFromFile(FilesPaths.Deleteusers);
		RestClientHandler.sendDelete(connection, DeleteAll, HTTPRequestsContentTypes.JSON);
		String response = RestClientHandler.readResponse(connection);
		assertTrue("Data is empty", response.equals(""));	

	}
	@Test
	public void testDeleteuser() throws Exception {
		HttpURLConnection connection = RestClientHandler.connectServer(URLs.DeleteAllusers, HTTPMethod.DELETE,
				HTTPRequestsContentTypes.JSON);

		String  DeleteUsers = JSONUtils.readJSONObjectFromFile(FilesPaths.Deleteusers);
		RestClientHandler.sendDelete(connection, DeleteUsers, HTTPRequestsContentTypes.JSON);
		String response = RestClientHandler.readResponse(connection);
		String CreatUser = JSONUtils.readJSONObjectFromFile(FilesPaths.Deleteusers);
		assertTrue("The deletion was successful",CreatUser.equals(response));

		RestClientHandler.sendPost(connection, CreatUser, HTTPRequestsContentTypes.JSON);
		
		String PostUser = RestClientHandler.readResponse(connection);
		assertTrue("Data is empty", !PostUser.equals(""));	

	}

}

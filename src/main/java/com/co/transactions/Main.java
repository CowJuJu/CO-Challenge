//package com.co.transactions;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.*;
//import org.apache.http.client.*;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.util.EntityUtils;
//
///**
// * Created by louisvadis on 5/6/17.
// */
//
//public class Main {
//	
//	public static void webServiceLogin() throws IOException{
//
//		String loginUrl = "https://2016.api.levelmoney.com/api/v2/core/login";
//		String transactionUrl = "https://2016.api.levelmoney.com/api/v2/core/get-all-transactions";
//		HttpResponse  response = null;
//        try {
//        	HttpClient httpClient = HttpClientBuilder.create().build();
//        	HttpPost post  = new HttpPost(loginUrl);
//        	
//        	post.addHeader("Accept", "application/json");
//        	post.addHeader("Content-Type", "application/json");
//        	post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:9.0.1) Gecko/20100101 Firefox/9.0.1");
//
//        	//,\"json-strict-mode\":false,\"json-verbose-response\",false
//        	//post.addHeader("email", "interview@levelmoney.com");
//        	//post.addHeader("password", "password2");
//        	//{"email":  "interview@levelmoney.com", "password":  "password2", "args": {"uid":  1110590645, "token":  "0C8362E2EBC586ED313B5651A666C84B", "api-token":  "AppTokenForInterview", "json-strict-mode": false, "json-verbose-response": false}, "demo-account-type": "default"}
//        	String args="{\"email\":\"interview@levelmoney.com\",\"password\":\"password2\",\"args\":{\"uid\":1110590645,\"token\":\"0C8362E2EBC586ED313B5651A666C84B\",\"api-token\":\"AppTokenForInterview \",\"json-strict-mode\":false,\"json-verbose-response\",false},\"demo-account-type\":\"default\"}";
//        	//List<NameValuePair> params = new ArrayList<NameValuePair>(2);
//        	//params.add(new BasicNameValuePair("email", "interview@levelmoney.com"));
//        	//params.add(new BasicNameValuePair("password", "password2"));
//        	
//        	//params.add(new BasicNameValuePair("args", "{\"uid\":1110590645,\"token\":\"7EE887C7FE3B46BD87B77F1FCE031EAA\",\"api-token\":\"AppTokenForInterview \",\"json-strict-mode\":false,\"json-verbose-response\",false}"));
//        	//params.add(new BasicNameValuePair("demo-account-type", "default"));
//        	
//        	//post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//        	
//        	post.addHeader("args",args);
//        	//post.addHeader("demo-account-type", "default");
//        	
//        	//Header[] header = post.getAllHeaders();
//        	//System.out.println(header.length);
//        	//for(int i = 0; i < header.length; i++){
//        		//System.out.println(header[i].getValue().toString());
//        	//}
//        	
//	        response = httpClient.execute(post);
//            if (response.getStatusLine().getStatusCode() != 200) {
//              throw new RuntimeException("Failed : HTTP error code : "
//                        + response.getStatusLine().getStatusCode());
//            } else {
//                if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
//                    throw new Exception(response.getStatusLine().getReasonPhrase());
//                }
//                HttpEntity responseEntity = response.getEntity();
//                String responseString = EntityUtils.toString(responseEntity, "UTF-8");
//                System.out.println(response.getStatusLine().getStatusCode() + responseString);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
//	
//	public static void main(String[] args) {
//	    try {
//	    	webServiceLogin();
//	    } catch(IOException ioe) {
//	        System.out.println(ioe);
//	    }
//	}
//}

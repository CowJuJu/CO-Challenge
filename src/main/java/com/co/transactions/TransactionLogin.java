package com.co.transactions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.co.transactions.domain.Login.LoginResponse;
import com.co.transactions.domain.transaction.Transaction;
import com.co.transactions.domain.transaction.Transactions;
import com.co.transactions.util.DateUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TransactionLogin {
	
	static Transaction transaction = new Transaction();
	
	public static void main(String[] args) {
		final String loginUrl = "https://2016.api.levelmoney.com/api/v2/core/login";
		final String transactionUrl = "https://2016.api.levelmoney.com/api/v2/core/get-all-transactions";
		
	    RestTemplate loginTemplate = new RestTemplate();
	    
	   String input = "{\"email\":\"interview@levelmoney.com\",\"password\":\"password2\",\"args\":{\"api-token\":\"AppTokenForInterview\"}}";

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    
	    JsonElement jelement = new JsonParser().parse(input);
	    JsonObject  jobject = jelement.getAsJsonObject();
	   
	    HttpEntity<String> entity = new HttpEntity<String>(jobject.toString(),headers);
	    ResponseEntity<String> result = loginTemplate.postForEntity(loginUrl, entity, String.class);
	    String responseJson = result.getBody();
	    JsonElement response = new JsonParser().parse(responseJson);
	    JsonObject  responseObject = response.getAsJsonObject();
	    
	    JsonElement uid = responseObject.get("uid");
	    int uidstr = uid.getAsInt();
	    
	    JsonElement token = responseObject.get("token");
	    String tokenstr = token.getAsString();
	    
	    LoginResponse loginResponse = new LoginResponse(uidstr,tokenstr);
	    
	    RestTemplate TransactionTemplate = new RestTemplate();
	    
	    String transactionCall = "{\"args\":{\"uid\":"+loginResponse.getUid()+",\"token\":"+loginResponse.getToken()+",\"api-token\":\"AppTokenForInterview\",\"json-strict-mode\":false,\"json-verbose-response\":false}}";

	    JsonElement transactionCallElement = new JsonParser().parse(transactionCall);
	    JsonObject  transactionCallObject = transactionCallElement.getAsJsonObject();
	    
	    HttpEntity<String> transactionCallEntity = new HttpEntity<String>(transactionCallObject.toString(),headers);
	    ResponseEntity<String> transactionCallEntityResult = TransactionTemplate.postForEntity(transactionUrl, transactionCallEntity, String.class);
	    String transactionCallEntityJson = transactionCallEntityResult.getBody();
	    
	    JsonElement transactionCallResponse = new JsonParser().parse(transactionCallEntityJson);
	    JsonObject  fullTransactionCallResponseObject = transactionCallResponse.getAsJsonObject();
	    JsonElement transactionCallResponseElement = fullTransactionCallResponseObject.get("transactions");
	    JsonArray transactionCallResponseArray = transactionCallResponseElement.getAsJsonArray();
	    
	    Transactions transactions = new Transactions();
	    List<Transaction> transactionList = new ArrayList<Transaction>();
	    
	    for(int i = 0; i < transactionCallResponseArray.size();i++) {
	    	JsonElement currentElement = transactionCallResponseArray.get(i);
	    	JsonObject currentObject = currentElement.getAsJsonObject();
	    	transaction.setAccountId(currentObject.get("account-id").getAsString());
	    	transaction.setAmount(currentObject.get("amount").getAsDouble());
	    	transaction.setCategorization(currentObject.get("categorization").getAsString());
	    	transaction.setClearDate(currentObject.get("clear-date").getAsString());
	    	transaction.setMerchant(currentObject.get("merchant").getAsString());
	    	transaction.setPending(currentObject.get("is-pending").getAsBoolean());
	    	transaction.setTransactionId(currentObject.get("transaction-id").getAsString());
	    	transaction.setTransactionTime(currentObject.get("transaction-time").getAsString());
	    	//System.out.println(transaction.getTransactionTime());
	    	transactionList.add(transaction);
	    }
	    transactions.setTransactions(transactionList);
	    StringBuffer firstDate = new StringBuffer();
	    StringBuffer secondDate = new StringBuffer();
	    boolean isSameMonth = false;
	    for(int i = 0; i < transactions.getTransactions().size();i++){
	    	if(i == 0){
	    		firstDate.append(transactions.getTransactions().get(i).getTransactionTime());
	    	} else if(firstDate.toString() != null && i%2==1){
	    		firstDate.delete(0,firstDate.length());
	    		firstDate.append(transactions.getTransactions().get(i).getTransactionTime());
	    		System.out.println(firstDate.toString());
	    	} else if(secondDate.toString() != null && i%2==0) {
	    		secondDate.delete(0, secondDate.length());
	    		secondDate.append(transactions.getTransactions().get(i).getTransactionTime());
	    		System.out.println(secondDate.toString());
	    	} else {
	    		System.out.println("Error in calculating Amount");
	    	}
	    	try {
	    		if(i > 1){
	    			isSameMonth = DateUtil.isSameYearAndMonth(firstDate.toString(),secondDate.toString());
	    			//System.out.println(isSameMonth);
	    		} else {
	    			continue;
	    		}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	    }
	}

}

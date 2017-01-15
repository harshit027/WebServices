package com.mywebservice.utils;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

public class DatabaseClient {

	private static DatabaseClient instance = null;
	private MongoClient mongo = null;
	private DatabaseClient()
	{
		  
	}
	
	public static DatabaseClient getInstance()
	{
		if(instance == null)
		{
			instance = new DatabaseClient();
		}
		return instance;
	}
	public MongoClient getMongoDBClient() throws UnknownHostException
	{
		mongo =  new MongoClient("localhost",27017);
		return mongo;
	}
	
}

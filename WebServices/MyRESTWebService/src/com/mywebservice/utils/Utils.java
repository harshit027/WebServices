package com.mywebservice.utils;

import java.net.UnknownHostException;
import java.util.UUID;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mywebservice.library.Book;

public class Utils 
{
	public static String getId()
	{
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}
}

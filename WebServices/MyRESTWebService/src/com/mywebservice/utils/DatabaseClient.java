package com.mywebservice.utils;

import java.net.UnknownHostException;

import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mywebservice.library.Book;

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

	public void insertBookObject(Book bookObject, DB db)
	{
		DBCollection bookTable = db.getCollection("books");
		BasicDBObject bookDocument = new BasicDBObject();
		bookDocument.put("id", bookObject.getBookId());
		bookDocument.put("name",bookObject.getBookName());
		bookDocument.put("author", bookObject.getBookAuthor());
		bookTable.insert(bookDocument);
	}
	
	public Book readBookObject(String searchString, DB db)
	{
		Book bookObject =  null;
		BasicDBObject query =  new BasicDBObject();
		DBCollection bookTable = db.getCollection("books");
		if(searchString.contains("author:"))
		{ 
			query.put("author", searchString.split(":")[1]);
			DBCursor cursor = bookTable.find(query);
			if(cursor.hasNext())
			{
				DBObject result = cursor.next();
				bookObject = new Book();
				bookObject.setBookId((String)result.get("id"));
				bookObject.setBookName((String)result.get("name"));
				bookObject.setBookAuthor((String)result.get("author"));
			}
		}
		else
			if(searchString.contains("name:"))
			{
				query.put("name", searchString.split(":")[1]);
				DBCursor cursor = bookTable.find(query);
				if(cursor.hasNext())
				{
					DBObject result = cursor.next();
					bookObject = new Book();
					bookObject.setBookId((String)result.get("id"));
					bookObject.setBookName((String)result.get("name"));
					bookObject.setBookAuthor((String)result.get("author"));
				}
			}
		return bookObject;
			
	}
}

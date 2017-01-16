package com.mywebservice.library;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mywebservice.utils.DatabaseClient;
import com.mywebservice.utils.Utils;


@Path("/simplelibrary")
public class SimpleLibrary 
{
	
	@Path("produce/xml/{searchString}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Book getBookXML(@PathParam("searchString")String searchString)
	{
		Book b = null;
		if(searchString.contains("author:") || searchString.contains("name:"))
		{
			try
			{
				DB db = DatabaseClient.getInstance().getMongoDBClient().getDB("webservices");
				b = DatabaseClient.getInstance().readBookObject(searchString, db);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return b;
	}
	
	@Path("produce/json/{searchString}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookJSON(@PathParam("searchString")String searchString)
	{
		Book b = null;
		if(searchString.contains("author:") || searchString.contains("name:"))
		{
			try
			{
				DB db = DatabaseClient.getInstance().getMongoDBClient().getDB("webservices");
				b = DatabaseClient.getInstance().readBookObject(searchString, db);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		return b;
	}
	
	@Path("consume/xml")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String consumeXMLRequest(Book bookObj)
	{
		try
		{
			bookObj.setBookId(Utils.getId());
			DB db = DatabaseClient.getInstance().getMongoDBClient().getDB("webservices");
			DatabaseClient.getInstance().insertBookObject(bookObj,db);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "<response>FAILURE</response>";
		}
		return "<response>SUCCESS</response>";
	}
	
	@Path("consume/json")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response consumeJSONRequest(Book bookObj) throws JSONException
	{
		//save in database
		JSONObject jsonObject = new JSONObject();
		try
		{
			bookObj.setBookId(Utils.getId());
			DB db = DatabaseClient.getInstance().getMongoDBClient().getDB("webservices");
			DatabaseClient.getInstance().insertBookObject(bookObj,db);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			jsonObject.put("result","FAILURE");
			return Response.status(200).entity(jsonObject.toString()).build();
		}
	
		jsonObject.put("result","SUCCESS");
		return Response.status(200).entity(jsonObject.toString()).build();
	}
}

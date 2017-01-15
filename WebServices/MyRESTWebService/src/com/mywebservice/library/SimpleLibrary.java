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


@Path("/simplelibrary")
public class SimpleLibrary 
{
	
	@Path("produce/xml/{bookName}/{bookAuthor}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Book getBookXML(@PathParam("bookName") String bookName, @PathParam("bookAuthor") String bookAuthor)
	{
		Book b = new Book();
		b.setBookName(bookName);
		b.setBookAuthor(bookAuthor);
		return b;
	}
	
	@Path("produce/json/{bookName}/{bookAuthor}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookJSON(@PathParam("bookName") String bookName, @PathParam("bookAuthor") String bookAuthor)
	{
		Book b = new Book();
		b.setBookName(bookName);
		b.setBookAuthor(bookAuthor);
		return b;
	}
	
	@Path("consume/xml")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String consumeXMLRequest(Book bookObj)
	{
		System.out.println(bookObj.getBookName() + "," +bookObj.getBookAuthor());
		return "<response>SUCCESS</response>";
	}
	
	@Path("consume/json")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response consumeJSONRequest(Book bookObj) throws JSONException
	{
		//System.out.println(bookObj.getBookName() + "," +bookObj.getBookAuthor());
		//save in database
		JSONObject jsonObject = new JSONObject();
		try
		{
			DB db = DatabaseClient.getInstance().getMongoDBClient().getDB("webservices");
			DBCollection bookTable = db.getCollection("books");
			BasicDBObject bookDocument = new BasicDBObject();
			bookDocument.put(bookObj.getBookName(), bookObj.getBookAuthor());
			bookTable.insert(bookDocument);
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

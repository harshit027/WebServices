package com.mywebservice.library;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

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
	public void consumeXMLRequest(Book bookObj)
	{
		System.out.println(bookObj.getBookName() + "," +bookObj.getBookAuthor());
	}
	
	@Path("consume/json")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void consumeJSONRequest(Book bookObj)
	{
		System.out.println(bookObj.getBookName() + "," +bookObj.getBookAuthor());
	}
}

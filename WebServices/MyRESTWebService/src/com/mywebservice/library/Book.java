package com.mywebservice.library;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book 
{
	private String bookName;
	private String bookAuthor;
	
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	public String getBookAuthor() 
	{
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) 
	{
		this.bookAuthor = bookAuthor;
	}
}

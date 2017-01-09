package com.mywebservice.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/simplecalculator")
public class SimpleCalculator 
{
	@GET
	@Produces("application/xml")
	@Path("/{operation}/{a}/{b}")
	public String executeOperation(@PathParam("operation") String operation, @PathParam("a") double a, @PathParam("b") double b)
	{
		String response = null;
		if( b==0 )
		{
			return this.getErrorResponse("Invalid Argument");
		}
			
		double result = 0;
		switch(operation)
		{
		case "addition":
			result = a+b;
			break;
		case "subtraction":
			result = a-b;
			break;
		case "division":
			result = a/b;
			break;
		case "multiplication":
			result = a*b;
			break;
		default:
			return this.getErrorResponse("Invalid Operation");
		}
		response = "<simplecalculator>" +
						"<operation>"+
							"<name>"+operation+"</name>"+
							"<result>"+result +"</result>"+
						"</operation>"+
					"</simplecalculator>";
		return response;
	}
	
	private String getErrorResponse(String error)
	{
		String response  = "<simplecalculator>"+
								"<operation>"+
									"<error>"+error+"</error>"+
								"</operation>"+
							"</simplecalculator>";
		return response;
	}
	
}

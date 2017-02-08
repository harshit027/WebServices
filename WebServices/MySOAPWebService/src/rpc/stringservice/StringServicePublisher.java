package rpc.stringservice;

import javax.xml.ws.Endpoint;  
public class StringServicePublisher {
	public static void main(String args[]){
		Endpoint.publish("http://localhost:8000/mywebservice/strings", new StringOperationImpl());
	}
}

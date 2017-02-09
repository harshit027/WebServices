package document.stringclient;

import java.net.MalformedURLException;
import java.net.URL;  
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;

import document.stringservice.StringOperation;

public class StringOperationClient {

	public static void main(String args[]){
		URL url = null;
		try{
			url =  new URL("http://localhost:8000/mywebservice/strings?wsdl");
		}
		catch(MalformedURLException e){
			System.out.println(e);
		}
		/*
		 * 1st argument = xmlns:tns in WSDL
		 * 2nd argument = service name in WSDL
		 */
		QName qname = new QName("http://stringservice.document/", "StringOperationImplService");  
        Service service = Service.create(url, qname);  
        StringOperation obj = service.getPort(StringOperation.class);  
        System.out.println(obj.getLength("teststring"));
	}
}

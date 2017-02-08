package rpc.stringservice;

import javax.jws.WebService;  

@WebService (endpointInterface = "rpc.stringservice.StringOperation")  
public class StringOperationImpl implements StringOperation{
	@Override
	public int getLength(String str){
		return str.length();
	}
}

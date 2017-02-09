package document.stringservice;

import javax.jws.WebMethod;
import javax.jws.WebService;  
import javax.jws.soap.SOAPBinding;  
import javax.jws.soap.SOAPBinding.Style; 

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface StringOperation {
	@WebMethod int getLength(String str);
}

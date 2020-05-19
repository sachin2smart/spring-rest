package in.sachinshinde.springrestdemo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sachinshinde.springrestdemo.model.Message;
/*
 * 		
1. Can we have a single endpoint serving both GET & POST methods
-->	Yes, we can have that.
	Annottate both methods with @GetMapping() & @PostMapping with same path-url names at both the places 
	
2. Creation of a single endpoint to server both XML & JSON requests
-->	Yes, it is possible 
	Add "jackson-dataformat-xml" dependency for conversion of JSON to XML (Version: 2.4.3)
	At Server Side:
		Annotate a RestController class with @Provider annotation 
		Specify consumer as method level :
			@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		Specify producer as method level :
			@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
			
	At the client side:
		Keep the request body input in JSON or XML format as required. 
		Add the "Accept" header with value as "application/xml" or "application/json" as per the requirement 
		
	We can send an XML and can retrieve the JSON if required
 * 
 */
@RestController
@Provider
public class MessageController{
	
	@GetMapping("/message")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Message getMessage() {
	    return new Message("first message");
	}
	
	@PostMapping("/message")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	Message echoMessage(@RequestBody Message message) {
		return message;
	}

}

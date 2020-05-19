# spring-rest
Problems solved in spring-rest

1. Can we have a single endpoint serving both GET & POST methods <br />
-->	Yes, we can have that. <br />
	Annottate both methods with @GetMapping() & @PostMapping with same path-url names at both the places <br />
	
2. Creation of a single endpoint to server both XML & JSON requests<br />
-->	Yes, it is possible <br />
	Add "jackson-dataformat-xml" dependency for conversion of JSON to XML (Version: 2.4.3) <br />
	At Server Side: <br />
		Annotate a RestController class with @Provider annotation  <br />
		Specify consumer at method level as:  <br />
			@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  <br />
		Specify producer at method level as: <br />
			@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  <br />
			
	At the client side: <br />
		Keep the request body input in JSON or XML format as required.  <br />
		Add the "Accept" header with value as "application/xml" or "application/json" as per the requirement  <br />
		
	We can send an XML and can retrieve the JSON if required  <br />
	
	Code Sample: <br/> 
	 </t>></t>  https://github.com/sachin2smart/spring-rest/blob/master/springrestdemo/src/main/java/in/sachinshinde/springrestdemo/controller/MessageController.java 

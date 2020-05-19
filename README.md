# spring-rest
Problems solved in spring-rest

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

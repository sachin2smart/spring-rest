package in.sachinshinde.springrestdemo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mockito.internal.matchers.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MovieMetadataController {
	
	@GetMapping("/getMovieMetadata")
	public List<String> getMovieMetadata() {
		try{
			BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/static/movies_metadata.csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());
			
			List<Integer> Ids = new ArrayList<Integer>();
			List<String> original_titles = new ArrayList<String>();
			List<String> runtimes = new ArrayList<String>();
			List<String> production_companies = new ArrayList<String>();
			
			for(CSVRecord csvRecord: csvParser) {				 
				 Ids.add(Integer.parseInt(csvRecord.get(5)));
				 original_titles.add(csvRecord.get(8));
				 runtimes.add(csvRecord.get(16));
				 production_companies.add(csvRecord.get(12));
			}
			 /*
			  * The forEach method is a default method defined in the Iterable interface. 
			  * The FOREACH function performs a computation on every member of a set or sets and assembles the results into a set.
			  * Collection classes which extends Iterable interface can use forEach loop to iterate elements.
			  * 
			  * Here we have used ArrayList & iterated over the elements using the Lambda Expression & 
			  * method reference.
			  */
			
			// Iterating by using the Lambda expression
//			 Ids.forEach((s)->System.out.println(s));
//			 runtimes.forEach(s->System.out.println(s));
			 
			// Iterating using the method reference
//			 original_titles.forEach(System.out::println);
			 
			// **  filter() : Returns a stream consisting of the elements of this stream that match the given predicate.
				//			Parameters: predicate
				//			Returns: the new stream
			// get the Movie names starting with a letter "T"
//			 original_titles = original_titles.stream().filter(s->s.startsWith("T")).collect(Collectors.toList());
			 
			// get the movie names having title size in 5...8 exclusive
//			 original_titles = original_titles.stream().filter(s->s.length()>5 && s.length()<8).collect(Collectors.toList());
			
			// ** map() : Returns a stream consisting of the results of applying the given function to the elements of this stream.
				//			Parameters: mapper 
				//			Returns: the new stream		
			
			// ***** map() test 1 : get the movies names in upper case
			
//			original_titles = original_titles
//									.stream()
//									.map(String::toUpperCase)
//									.collect(Collectors.toList());

			// ***** map() test 2 : Get the runtime if the runtime is more than 80.
			//						Specify it as a mini-clip, if the runtime is less than 80

//			runtimes = runtimes
//							.stream()
//							.map(
//										s->
//											{
//												if(!s.isEmpty()) 
//													if(Double.parseDouble(s)>80) 
//														return s; 
//													else 
//														return "This is a mini clip"; 
//												else 
//													return "Runtime not specified";
//												}
//								)
//							.collect(Collectors.toList());
			
//			Stream.concat(Ids.stream(),original_titles.stream()).forEach(System.out::println);
//			production_companies.forEach(System.out::println);
			production_companies = production_companies
											.stream()
											.map(
													s->
														{
															s = s.toString().replace('\'', '"');
															try {
															JSONParser parser = new JSONParser();
															Optional<JSONObject> jObj = (Optional<JSONObject>) parser.parse(s);
//															
																if(jObj.isPresent()) {
																	System.out.println(jObj);
																}else {
																	System.out.println("Not Present.");
																}
//																Optional.ofNullable(s.getJSONObject())
															}catch(Exception e) {
																System.out.println("Exception :"+ e);
															}
															
															return s;
														}
												)
											.collect(Collectors.toList());
			csvParser.close();
			
			// Get the maximum runtime among the movies 
			Optional<Double> max_runtimes = runtimes
												.stream()
												.map(
															s->
																{
																		if(!s.isEmpty()) 
																			return Double.parseDouble(s);
																		else
																			return -9999.0;
																}
													)
												.max(Comparator.naturalOrder());
			
			System.out.println("Min Runtime: "+max_runtimes.get());
			 
			 return production_companies;
			 
		}catch(FileNotFoundException e) {
			System.out.println("File not found Exception: "+ e);
		}catch(Exception e) {
			System.out.println("Exception occured : " + e);
		}
		
		return null;
	}
	
}

package in.sachinshinde.springrestdemo.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieMetadataController {
	
	@GetMapping("/getMovieMetadata")
	public void getMovieMetadata() {
		try{
			BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/static/movies_metadata.csv"));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader().withIgnoreHeaderCase().withTrim());
			
			List<Integer> Ids = new ArrayList<Integer>();
			List<String> original_titles = new ArrayList<String>();
			List<String> runtimes = new ArrayList<String>();

			for(CSVRecord csvRecord: csvParser) {				 
				 Ids.add(Integer.parseInt(csvRecord.get(5)));
				 original_titles.add(csvRecord.get(8));
				 runtimes.add(csvRecord.get(16));
			}
			 
			 Ids.forEach((s)->System.out.println(s));
			 runtimes.forEach(s->System.out.println(s));
			 original_titles.forEach(System.out::println);
			 
			 csvParser.close();

		}catch(FileNotFoundException e) {
			System.out.println("File not found Exception: "+ e);
		}catch(Exception e) {
			System.out.println("Exception occured : " + e);
		}
	}
	
}

package in.sachinshinde.springrestdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sachinshinde.springrestdemo.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/getEmployeeData")
	public Map<String, Set<Integer>> getEmployeeData() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John", 40));
		employees.add(new Employee("John", 30));   
		employees.add(new Employee("Mike", 30));

		Map<Integer, Set<String>> map = employees.stream()
										.collect(
												Collectors.groupingBy(
																	Employee::getAge, 
																	Collectors.mapping(
																			Employee::getName,
																			Collectors.toSet()
																	)
																)
												);
		
		List<Employee> employees2 = new ArrayList<>();
		employees2.add(new Employee("John", 40));
		employees2.add(new Employee("John", 45));   // Will not work, since the duplicate will occur
		employees2.add(new Employee("Mike", 30));
		
		Map<String, Set<Integer>> map2 = employees2.stream()
														.collect(
																Collectors.groupingBy(
																					Employee::getName, 
																					Collectors.mapping(
																							Employee::getAge,
																							Collectors.toSet()
																					)
																				)
																);
		
		System.out.println(map2);
		
		return map2;
		
	}
}

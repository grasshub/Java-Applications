package org.hong.javafundamental.jackson2;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJason {
	
	private static final String NAME = "John Doe";
	private static final int AGE = 33;
	private static final String POSITION = "Developer";
	private static final int SALARY = 100000;
	private static final String JAVA = "Java";
	private static final String PYTHON = "Python";
	private static final String FILE_PATH = "C:/mytemp/jsonFile.json";
	
	private static Employee createEmployee() {
		Employee employee = new Employee();
		
		employee.setName(NAME);
		employee.setAge(AGE);
		employee.setPosition(POSITION);
		employee.setSalary(new BigDecimal(SALARY));
		
		List<String> skills = new ArrayList<String>();
		skills.add(JAVA);
		skills.add(PYTHON);
		
		employee.setSkills(skills);
		
		return employee;
	}
	
	public static void main(String[] args) {
		
		Employee employee = createEmployee();
		
		// Create ObjectMapper to convert Java object to JSON data
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			// Convert Java object to JSON data and save into file
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), employee);
			
			// Convert object to JSON string
			String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
			System.out.println(jsonString);
			
			// Convert JSON data from file to Java Object
			Employee employee1 = mapper.readValue(new File(FILE_PATH), Employee.class);
			System.out.println(employee1);
			
			// Convert JSON String to object
			String jsonString1 = "{\"name\":\"John Doe\", \"age\":24, \"position\":\"VP\", \"salary\":75000, \"skills\":[\"java\", \"python\"]}";
			Employee employee2 = mapper.readValue(jsonString1, Employee.class);
			System.out.println(employee2);
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee2));
			
			// Convert JSON Array or Map to Java List and Map
			String json = "[{\"name\":\"John Doe\"}, {\"name\":\"Henry Smith\"}]";
			List<Employee> employeeList = mapper.readValue(json, new TypeReference<List<Employee>>(){});
			
			for (Employee emp : employeeList) {
				System.out.println(emp.getName());
			}
			
			// Convert JSON to Map
			String jsonStr = "{\"name\":\"John Doe\", \"age\":33}";
			Map<String, Object> employeeMap = mapper.readValue(jsonStr, new TypeReference<Map<String,Object>>(){});
			
			for (String key : employeeMap.keySet()) {
				System.out.println(key);
				System.out.println(employeeMap.get(key));
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

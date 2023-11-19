package Program.A1;

import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Course {
	
//	Read CSV file.
	
	public List<List<String>> readCSV(String file) {
		
		List<List<String>> records = new ArrayList<>();
		String COMMA_DELIMITER = ",";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    
			String line;
		    while ((line = br.readLine()) != null) {
		        
		    	String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));
		    }
		    records.remove(0);
		}
		// Catching Exceptions.
		catch(IndexOutOfBoundsException e) {
		    System.out.println("Error in CSV file format: " + e.getMessage());
			System.out.println("Ending program now");
			System.exit(1);
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to locate file with course information.");
			System.out.println("Ending program now, Please insert file and try again !!");
			System.exit(1);
		} 
		catch (IOException e) {
			System.out.println("Error reading the file " + file);
			System.out.println("Ending program now");
			System.exit(1);
		}
		
		return records;
	}
	
	
//	Create list of CourseDetail objects using CSV file data.
	
	public ArrayList<CourseDetails> totalCourses(String fileName){
		
		ArrayList<CourseDetails> total = new ArrayList<CourseDetails>();
		List<List<String>> csvData = readCSV(fileName);
		
		for(int i = 0; i < csvData.size(); i++) {
			List<String> listElements = csvData.get(i);
			CourseDetails details = new CourseDetails(listElements);
			
			total.add(details);
		}
		
		return total;
	}
	
//	Search for a course.
	
	public ArrayList<CourseDetails> search (String courseIdentifier){
		
		ArrayList<CourseDetails> validSearches = new ArrayList<CourseDetails>();
		
		Course course = new Course();
		ArrayList<CourseDetails> allCourses = course.totalCourses("course.csv");
		
		Pattern pattern = Pattern.compile(courseIdentifier, Pattern.CASE_INSENSITIVE);
		
		
		for(int i = 0; i < allCourses.size(); i++) {
			Matcher matcher = pattern.matcher(allCourses.get(i).getName());
			
			if(matcher.find()) {
				validSearches.add(allCourses.get(i));
			}
		}
		return validSearches;
	}
	
	
//	Main Function.
	
	public static void main(String[] args) {

	}
}
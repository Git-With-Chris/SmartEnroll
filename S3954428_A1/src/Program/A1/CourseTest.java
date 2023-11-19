package Program.A1;

import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;
import java.io.*;



public class CourseTest {
	private static final String FILE_NAME_RECORDS = "test1.csv";
	private static final String FILE_NAME_TOTAL = "test2.csv";
	private List<List<String>> expectedRecords;
	private ArrayList<CourseDetails> expectedTotal;
	
	@Before
	public void setUp() throws Exception {
		expectedRecords = new ArrayList<>();
		expectedRecords.add(Arrays.asList("Chris", "John", "24"));
		expectedRecords.add(Arrays.asList("Sahinya", "Akila", "25"));
		
		expectedTotal = new ArrayList<CourseDetails>();
		// Add expected CourseDetails objects to the expected total list
		expectedTotal.add(new CourseDetails(Arrays.asList("Java programming", "120", "Year 1", "Face-to-face", "Wednesday", "11:30", "2")));
		expectedTotal.add(new CourseDetails(Arrays.asList("Programming skills", "500", "Year 1", "Face-to-face", "Tuesday", "8:30", "1")));
		expectedTotal.add(new CourseDetails(Arrays.asList("Advanced Python programming", "40", "Year 2",	"Face-to-face",	"Friday", "16:00",	"1.5")));
		
		
		
		// Create the test CSV file
		try (PrintWriter writer = new PrintWriter(new File(FILE_NAME_RECORDS))) {
			writer.println("First Name,Last Name,Age");
			writer.println("Chris,John,24");
			writer.println("Sahinya,Akila,25");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		// Create the course CSV file
		try (PrintWriter writer = new PrintWriter(new File(FILE_NAME_TOTAL))) {
			writer.println("Course name,Capacity,Year,Delivery mode,Day of lecture,Time of lecture,Duration of lecture (hour)");
			writer.println("Java programming,120,Year 1,Face-to-face,Wednesday,11:30,2");
			writer.println("Programming skills,500,Year 1,Face-to-face,Tuesday,8:30,1");
			writer.println("Advanced Python programming,40,Year 2,Face-to-face,Friday,16:00,1.5");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadCSV() {
		// Call the readCSV() function and compare the result with the expected records
		Course course = new Course();
		List<List<String>> actualRecords = course.readCSV(FILE_NAME_RECORDS);
		assertEquals(expectedRecords, actualRecords);
	}
	
	@Test
	public void testTotalCourses() {
		// Call the totalCourses() function and compare the result with the expected total list
		Course course = new Course();
		ArrayList<CourseDetails> actualTotal = course.totalCourses(FILE_NAME_TOTAL);
		for(int i = 0; i < actualTotal.size(); i++) {
			assertEquals(actualTotal.get(i).getName(), expectedTotal.get(i).getName());
		}
		
	}
	
	@Test
	public void testSearch() {
		Course course = new Course();
		ArrayList<CourseDetails> actualSearchResults = course.search("Java");
		System.out.println(actualSearchResults.get(0).getName());
		assertEquals(actualSearchResults.get(0).getName(), "Java programming");
	}

	
	@After
	public void tearDown() throws Exception {
		// Delete the test CSV file
		File file1 = new File(FILE_NAME_RECORDS);
		file1.delete();
		
		File file2 = new File(FILE_NAME_TOTAL);
		file2.delete();
	}

}

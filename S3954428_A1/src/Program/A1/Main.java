package Program.A1;

import java.util.ArrayList;
import java.util.*;

public class Main {

	
//	Draw line Function.
	private static void drawLine() {
		for(int i = 0; i < 60; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
//	Menu Function.

	private static String menu() {
		
	//	Initial Menu Bar
		System.out.println("\nWelcome to MyTimetable!");
		drawLine();
		System.out.println("> Select from Main Menu");
		drawLine();
		System.out.println("\t 1) Search by keyword to enroll.");
		System.out.println("\t 2) Show my enrolled courses.");
		System.out.println("\t 3) Withdraw from a course.");
		System.out.println("\t 4) Exit.");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Please select: ");
		String option = input.nextLine();
		return option;
		
		
	}
	
//	Main Function.
	public static void main(String[] args) {
		
		int checker = 0;
		ArrayList<CourseDetails> enrolledCourses = new ArrayList<CourseDetails>();
		
		while(checker == 0) {

			Course course = new Course();
			Scanner input = new Scanner(System.in);
			
			String option = menu();
			
//			Search for courses to enroll to.
			if(option.equals("1")) {
				try {
					System.out.print("Please enter Course Name or Keyword: ");
					String searchWord = input.nextLine();
					ArrayList<CourseDetails> searchedCourses = course.search(searchWord);
					
					//	Check for keyword validity.			
					if (searchedCourses.size() == 0) {
						System.out.println("\nNo course found with this name/keyword");
					}
					else {
						for(int i = 1; i <= searchedCourses.size(); i++) {
							System.out.println( i  + ".)  " + searchedCourses.get(i - 1).getName());
							}
						
						System.out.print("Please select an option: ");
						int choice = input.nextInt();
						int alreadyEnrolled = 0;
						
						// Check if already enrolled.						
						for(int i = 0; i < enrolledCourses.size(); i++) {
							if(enrolledCourses.get(i).getName().equals(searchedCourses.get(choice - 1).getName())) {
								System.out.println("You are already enrolled in this course");
								alreadyEnrolled = 1;
							}
						}
						if (alreadyEnrolled == 0){
							System.out.println("You are successfully enrolled in " + searchedCourses.get(choice - 1).getName());
							enrolledCourses.add(searchedCourses.get(choice - 1));
						}
						
					}
				}
				// Catching Exceptions.				
				catch(IndexOutOfBoundsException e) {
					System.out.println("Please enter a valid option");
				}
				catch(InputMismatchException e) {
						System.out.println("Please enter a valid option");
				}
			}
			
//			Show all enrolled courses.
			else if(option.equals("2")) {
				//	Check for enrollment validity.			
				if(enrolledCourses.size() == 0) {
					System.out.println("You are not enrolled in any courses currently.");
				}
				else {
					System.out.println("\nYou are enrolled in the following courses: \n");
					System.out.printf("   %-35s %-20s %-20s %-20s %-10s %-10s %-10s\n",
							"Name",
							"Day",
							"DeliveryMode",
							"Time",
							"Duration",
							"Capacity",
							"Year");
					for(int i = 0; i < enrolledCourses.size(); i++) {
						System.out.printf("%d) %-35s %-20s %-20s %-20s %-10s %-10s %-10s\n",
								i+1,
								enrolledCourses.get(i).getName(),
								enrolledCourses.get(i).getDay(),
								enrolledCourses.get(i).getDeliveryMode(),
								enrolledCourses.get(i).getTime(),
								enrolledCourses.get(i).getDuration(),
								enrolledCourses.get(i).getCapacity(),
								enrolledCourses.get(i).getYear());
					}
				}
			}
			
//			Withdraw from enrolled course.
			else if(option.equals("3")) {
				// Check for enrollment validity.
				if(enrolledCourses.size() == 0) {
					System.out.println("You are not enrolled in any courses currently.");
				}
				else {
					System.out.println("\nWhich course do you want to withdraw from ?\n");
					try{
						for(int i = 0; i < enrolledCourses.size(); i++) {
						System.out.println(i + 1 + ".) " + enrolledCourses.get(i).getName());
						}
						System.out.print("\nPlease select an option: ");
						int choice = input.nextInt();
						if(choice <= enrolledCourses.size() && choice != 0) {
							System.out.println("You have successfully withdrawn from " + enrolledCourses.get(choice - 1).getName());
							enrolledCourses.remove(choice - 1);
						}
						else {
						System.out.println("Please enter a valid option");
						}
					}
					// Catching Exceptions.
					catch(IndexOutOfBoundsException e) {
						System.out.println("Please enter a valid option");
					}
					catch(InputMismatchException e) {
						System.out.println("Please enter a valid option");
					}
				}
			}
		
//			Exit program.
			else if(option.equals("4")) {
				input.close();
				System.out.println("Thank you for using MyTimetable. See you soon!");
				checker = 1;
			}
			
			else {
				System.out.println("Please Enter a valid option. Lets try again!");
			}
		}
	}
}

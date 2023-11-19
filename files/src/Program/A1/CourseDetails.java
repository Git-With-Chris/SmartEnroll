package Program.A1;

import java.util.List;

public class CourseDetails {
	
	private String name = "";
	private String capacity = "";
	private String year = "";
	private String deliveryMode = "";
	private String day = "";
	private String time = "";
	private String duration = "";
	
	
//	1: Constructor for Course details.
	
	public CourseDetails(List<String> detailsList) {
		
		this.name = detailsList.get(0);
		this.capacity = detailsList.get(1);
		this.year = detailsList.get(2);
		this.deliveryMode = detailsList.get(3);
		this.day = detailsList.get(4);
		this.time = detailsList.get(5);
		this.duration = detailsList.get(6);
		
	}
	
//	2. Getter methods.
	
	public String getName() {
		return name;
	}
	
	public String getDeliveryMode() {
		return deliveryMode;
	}
	
	public String getDay() {
		return day;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getCapacity() {
		return capacity;
	}
	
//	3. Setter Methods.
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
//	4. Main Method.
	public static void main(String[] args) {

	}

}


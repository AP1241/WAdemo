//import com.sun.org.apache.xpath.internal.operations.Bool;

public class Book {
	private int id;
	private String title, date;
	private Boolean availability;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDate() {
		return date;
	}
	
	public Boolean getAvailability() {
		return availability;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
}

import java.util.ArrayList;

/**
 * This class is intended to represent a course. Having a name, credits, number
 * of seats, and roster of students.
 * @author sexybeast
 *
 */
public class Course {
	
	//Fields
	private String name;
	private int credits;
	private int totalSeats;
	private ArrayList<Student> studentRoster = new ArrayList<Student>();
	private int remainingSeats;
	
	//Constructors
	public Course(String name, int credits, int totalSeats) {
		this.name = name;
		this.credits = credits;
		this.totalSeats = totalSeats;
		this.remainingSeats = this.totalSeats;
	}
	/**
	 * Adds a new student to the course if there is a seat available.
	 * @param newStudent - Student object to be added
	 * @return true or false - if addition was successful
	 */
	public boolean addStudent(Student newStudent) { 
		//Verify that student is not already enrolled
		for (Student student : this.studentRoster) {
			if (newStudent.equals(student)){
				return false;
			}
		}
		
		//Verify that there are seats available
		if (this.remainingSeats < 1) {
			return false;
		}
		
		//Add student; update studentRoster and remainingSeats
		this.studentRoster.add(newStudent);
		this.remainingSeats -= 1;
		return true;
	}

	public String generateRoster() {
		String roster = " ";
		for (Student student : this.studentRoster) {
			roster += student + " ";
		}
		return roster;
	}

	public double averageGPA() {
		int totalStudents = 0;
		double sumGPA = 0;
		//Get each student's gpa in the course
		for (Student student : this.studentRoster) {
			sumGPA += student.getGPA();
			totalStudents++;
		}
		//Average their gpas
		double averageGPA = sumGPA / totalStudents;
		return averageGPA;
	}
	
	@Override
	public String toString() {
		return String.format("Course [name=%s, credits=%s, totalSeats=%s, studentRoster=%s, remainingSeats=%s]", name,
				credits, totalSeats, studentRoster, remainingSeats);
	}
	
	//Getters & Setters
	public String getName() {
		return this.name;
	}
	public int getCredits() {
		return this.credits;
	}
	public int getTotalSeats() {
		return this.totalSeats;
	}
	public ArrayList<Student> getStudentRoster() {
		return studentRoster;
	}
	public int getRemainingSeats() {
		return this.remainingSeats;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	
	//Main
	public static void main (String[] args) {
		//TODO
	}
}


import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class is intended to represent a student. Having a name, identification
 * number, credits, and a gpa.
 * @author sexybeast
 *
 */
public class Student {
	
	//Fields
	private ArrayList<String> name = new ArrayList<String>();
	private String nameFirst;
	private String nameLast;
	private int studentID;
	private int credits;
	private double gpa;
	
	//Constructors
	public Student(String firstName, String lastName, int i) {
		this.nameFirst = firstName;
		this.nameLast = lastName;
		String fullname = this.nameFirst + " " + this.nameLast;
		this.name.add(fullname);
		this.studentID = i;
		this.credits = 0;
		this.gpa = 0;
	}
	
	public Student(String firstName, String lastName, int id, double GPA, int credits) {
		this.nameFirst = firstName;
		this.nameLast = lastName;
		String fullname = this.nameFirst + " " + this.nameLast;
		this.name.add(fullname);
		this.studentID = id;
		this.credits = credits;
		this.gpa = GPA;
	}
	
	//Getters & Setters
	public String getName() {
		return this.name.get(0);
	}

	public int getStudentID() {
		return this.studentID;
	}

	public int getCredits() {
		return this.credits;
	}

	public double getGPA() {
		return this.gpa;
	}

	public void setName(String firstName, String lastName) {
		this.nameFirst = firstName;
		this.nameLast = lastName;
		String fullname = this.nameFirst + " " + this.nameLast;
		this.name.add(fullname);
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * Returns the student's class standing based on their credits.
	 * @return classStanding - The class this student is in based on credits.
	 */
	public String getClassStanding() {
		String classStanding = "Class Standing";
		if (this.credits < 30) {
			classStanding = "Freshman";
		}
		else if (this.credits >= 30 && this.credits <= 59) {
			classStanding =  "Sophomore";
		}
		else if (this.credits >= 60 && this.credits <= 89) {
			classStanding =  "Junior";
		}
		else if (this.credits >= 90) {
			classStanding =  "Senior";
		}
		return classStanding;
	}
	/**
	 * Updates the student's record, their total credits and gpa, based on the new course
	 * grade submission.
	 * @param courseGrade - a score between 0 and 4
	 * @param courseCredits - the number of credits this course awards
	 */
	public void submitGrade(double courseGrade, int courseCredits) {
		//quality score for current course
		double qualityScore;
		if (courseGrade < 0 || courseGrade > 4) {
			return;
		}
		else {
			qualityScore = (double)courseCredits * courseGrade;
		}
		//quality score for all courses
		double overallQualityScore = this.gpa * this.credits;
		
		//update student's total credits with new class credits
		this.credits = this.credits + courseCredits;
		
		//update student's gpa to include this course
		this.gpa = (overallQualityScore + qualityScore) / (this.credits);
		
		//round student's gpa to three decimal places		
		double fullGPA = this.getGPA();
		BigDecimal roundedGPA = new BigDecimal(fullGPA).setScale(3, BigDecimal.ROUND_HALF_UP);
		this.gpa = roundedGPA.doubleValue();
	}
	/**
	 * Computes the students total tuition based on semesters attended.
	 * @return tuition - the total tuition that the student has paid
	 */
	public double computeTuition() {
		int semesters = 1;
		
		if (this.credits <= 15){
			semesters = 1;
		}
		else if (this.credits > 15 && this.credits <= 30){
			semesters = 2;
		}
		else if (this.credits > 30 && this.credits <= 45){
			semesters = 3;
		}
		else if (this.credits > 45 && this.credits <= 60){
			semesters = 4;
		}
		else if (this.credits > 60 && this.credits <= 75){
			semesters = 5;
		}
		else if (this.credits > 75 && this.credits <= 90){
			semesters = 6;
		}
		else if (this.credits > 90 && this.credits <= 105){
			semesters = 7;
		}
		else if (this.credits > 105 && this.credits <= 120){
			semesters = 8;
		}
		double tuition = semesters * 20000.0;
		return tuition;
	}
	/**
	 * Creates a new student in partnership with another student. 
	 * @param parent2 - the other student
	 * @return
	 */
	public Student createLegacy(Student parent2) {
		int legacyID = this.getStudentID() + parent2.getStudentID();
		double legacyGPA = (this.getGPA() + parent2.getGPA()) / 2;
		int legacyCredits = Math.max(this.getCredits(), parent2.getCredits());
		
		Student legacyStudent = new Student(this.getName(), parent2.getName(), legacyID, legacyGPA, legacyCredits);
		return legacyStudent;
	}
	
	@Override
	public String toString() {
		return String.format("Student [name=%s, studentID=%s, credits=%s, gpa=%s]", name, studentID, credits, gpa);
	}
}

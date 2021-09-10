public class Student{
	private String studentName;
	private double examSum;
	private double examNumGrades;

	// Constructor
	public Student(String name){ studentName = name; }
	public String getName(){ return studentName; }
	public void addExam(double grade){ 
		examSum += grade; 
		examNumGrades++;
	}
	public double average(){
		if(examNumGrades == 0)
			return 100;
		else
			return examSum/examNumGrades;
	}
}
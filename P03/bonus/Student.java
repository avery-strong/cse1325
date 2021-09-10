public class Student{
	private String studentName;
	private double examSum;
	private double examNumGrades;

	// Constructor
	public Student(String name){ studentName = name; }
	public String getName(){ return studentName; }
	public boolean addExam(double grade){ 
		if(grade >= 0){
			examSum += grade; 
			examNumGrades++;

			return true;
		}
		
		return false;
	}
	public double average(){
		if(examNumGrades == 0)
			return 100;
		else
			return examSum/examNumGrades;
	}
}
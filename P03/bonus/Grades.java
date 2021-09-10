import java.util.Scanner;

public class Grades{
	public static void main(String[] args){
		boolean exit = true;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter student's name: ");
		
		Student student = new Student(in.nextLine());

		do{
			System.out.print("Enter next grade (< 0 when done): ");
			exit = student.addExam(in.nextDouble());
		}while(exit);

		System.out.println(student.getName() + " has a " + student.average() + " average.");
	}
}
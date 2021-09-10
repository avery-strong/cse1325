import java.util.Scanner;

public class Grades{
	public static void main(String[] args){
		String name;
		boolean exit = true;
		Scanner in = new Scanner(System.in);

		System.out.print("Enter student's name: ");
		name = in.nextLine();

		Student student = new Student(name);

		do{
			double grade;
			System.out.print("Enter next grade (< 0 when done): ");
			grade = in.nextDouble();

			// So Student does not except our negative value
			if(grade >= 0)
				student.addExam(grade);
			else
				exit = !exit;
		}while(exit);

		System.out.println(student.getName() + " has a " + student.average() + " average.");
	}
}
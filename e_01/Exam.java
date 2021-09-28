import java.util.*;

public class Exam{
	public static void cli(){
		ArrayList<Question> examQuestions = new ArrayList<>();

		/*
			*********MULTIPLE CHOICE QUESTIONS**********
		*/

		/* 1 */examQuestions.add( 
				new Question("___ Java handles multiple inheritance using")); 
		/* 2 */examQuestions.add( 
				new Question("___ The main method in class Gradebook can access which method in class Grade?"));
		/* 3 */examQuestions.add( 
				new Question("___ The default destructor for class Account in Java is declared as"));
		/* 4 */examQuestions.add( 
				new Question("___ To compare the value of int a and int b in Java, write"));
		/* 5 */examQuestions.add( 
				new Question("___ One advantage of a Java ArrayList over a traditional array is"));
		/* 6 */examQuestions.add( 
				new Question("___ To throw an exception for bad dates, write"));
		/* 7 */examQuestions.add( 
				new Question("___ Of the four arrows shown in the diagram above, the only one NOT a valid UML class relationship is"));
		/* 8 */examQuestions.add( 
				new Question("___ In Java, we would convert a String s to all upper case letters using"));
		/* 9 */examQuestions.add( 
				new Question("___ To invoke target \"clean\" in the local build.xml from the bash shell, type"));
		/* 10 */examQuestions.add( 
				new Question("___ Once class Animal has been declared, it may be instanced using"));
		/* 11 */examQuestions.add( 
				new Question("___ In the UML, an abstract method is shown with"));
		/* 12 */examQuestions.add( 
				new Question("___ The Java default constructor for class BigInt can chain to an overloaded constructor using"));
		/* 13 */examQuestions.add( 
				new Question("___ Java is"));
		/* 14 */examQuestions.add( 
				new Question("___ In the UML, a class is represented by"));
		/* 15 */examQuestions.add( 
				new Question("___ To print \"Hello, world!\" to the console in Java, write"));
	
		for(int i = 0; i < examQuestions.size(); i++){
			System.out.println(i+1 + " " + examQuestions.get(i).toString());
		}


	}
	public static void main(String[] args){
		Exam exam = new Exam();
		exam.cli();

		
	}
}

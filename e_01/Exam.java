import java.util.*;
import java.util.Scanner;

public class Exam{
	public static void cli(){
		Scanner in = new Scanner(System.in);
		ArrayList<Question> examQuestions = new ArrayList<>();

		/*
			*********MULTIPLE CHOICE QUESTIONS**********
		*/

		for(Questions a : Questions.values()){
			examQuestions.add( new Question(a.getQuestion(), a.getAnswers(), a.getCorrect()));
		}

		// Pass our exam questions and answers into our array
		// In the array parse our answers to each be seperated into the array in the object
		for(int i = 0; i < examQuestions.size(); i++){
			System.out.println();
			System.out.print((i + 1) + ". ");
			System.out.print(examQuestions.get(i).toString() 
				+ "\n\nYour answer: ");

			Character c01 = Character.toLowerCase(examQuestions.get(i).getCorrect());
			Character c02 = Character.toLowerCase(in.next().charAt(0));

			boolean equivalent = c01.equals(c02);

			if(equivalent)
				System.out.println("\nCorrect!");
			else
				System.out.println("\nIncorrect!");
		}
	}
	public static void main(String[] args){
		Exam exam = new Exam();
		exam.cli();

		
	}
}

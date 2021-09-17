import java.util.Scanner;

public class Boom{
	private static Puzzle puzzle = new Puzzle("Hakuna Matata");
	private static Fuze fuze = new Fuze(puzzle.getSolution().length());

	public static void cli(){
		Scanner in = new Scanner(System.in);

		System.out.println(
			"=================\n" 
			+ "B 0 0 M !\n" 
			+ "=================\n"
			+ "Enter lower case letters to guess,\n"
			+ "! to propose a solution,\n" 
			+ "0 to exit.\n");

		System.out.print(
			fuze.toString()
			+ "\n"
			+ "Guess a letter: ");

		char c = in.next().charAt(0);

	}
	public static void main(String[] args){
		cli();

	}
}
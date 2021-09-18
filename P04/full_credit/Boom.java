import java.util.Scanner;

/*
	This is simply the main class. 
	Code the game play in method cli(). 
	Then static method main() can instance Boom and call cli() so the player can play the game.
	You may be wondering where the phrase to be guessed originates. 
	You can either read the phrase from the console before the game starts 
	(presumably typed by a friend) OR select from a hard-coded list of 
	phrases.
	This problem is addressed very well (I think) in the extreme bonus.
*/
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

		puzzle.guess(in.next().charAt(0)); 
	}
	public static void main(String[] args){
		cli();

	}
}
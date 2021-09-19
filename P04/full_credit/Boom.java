import java.util.Scanner;
import java.lang.*;

/*
	This is simply the main class. 

	Code the game play in method cli(). 

	Then static method main() can instance Boom and call cli() so the 
	player can play the game.
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
		boolean burn = true;

		System.out.println(
			"=================\n" 
			+ "B 0 0 M !\n" 
			+ "=================\n"
			+ "Enter lower case letters to guess,\n"
			+ "! to propose a solution,\n" 
			+ "0 to exit.");

		// Gameplay begins
		do{
			System.out.print(
				fuze.toString()
				+ "\n"
				+ puzzle.toString()
				+ "\n"
				+ "Guess a letter: ");

			char c = in.next().charAt(0);

			// Eat the new line
			in.nextLine();

			// Allows for phrase input
			if(Character.compare(c, '!') == 0){
				System.out.print("What is the phrase? ");
				String s = in.nextLine();

				// If the phrase received was incorrect
				if(puzzle.solve(s) == false){
					break;
				}
				// Guessed the phrase correctly
				else{
					System.out.print(
						"** W I N N E R ***\n" 
						+ "The secret phrase was " 
						+ puzzle.getSolution());
					System.exit(0);
				}
			}
			// Exit
			else if(Character.compare(c, '0') == 0)
				System.exit(0);
			// Allows for single character input
			else{
				// Single character was incorrect
				if(puzzle.guess(c) == false)
					burn = fuze.burn();
				// Single character was guessed correctly
				else
					puzzle.guess(c);
			}
		}while(burn);
		
		System.out.print("\nYOUR FIRECRACKER WENT KABOOM!!!");
	}
	public static void main(String[] args){
		cli();
	}
}
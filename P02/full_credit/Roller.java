import java.util.Arrays;
import java.lang.Math;
/*
	In your git-managed cse1325 directory cse1325/P02/full_credit 
	(capitalization matters!), create a Java program in file Roller.java 
	that accepts exactly two command-line parameters: (1) the number of 
	dice to roll and (2) the number of faces per die.

	Create an array of ints and fill with the specified die rolls. 
	Consider Math.random() to generate the die rolls - it returns a float 
	between 0.0 and 1.0.

	Sort the array of ints using the function¹ Arrays.sort(array). 
	To do this, you'll need to first import java.util.Arrays.

	Then print each die roll separated by spaces, followed by the sum and 
	average of the rolls.
	You don't need to worry about error handling yet, as we'll cover that
	topic in the near future.

	If two command-line parameters are not provided, print to standard error 
	"usage: java Roll [#dice] [#sides]" and exit.
	Add, commit, and push all files to your private cse1325 GitHub repository.
	¹After Lecture 03, you'll recognize this as a static method rather than 
	a function.

*/
public class Roller{
	public static void main(String[] args){
		int[] dieRolls = new int[Integer.parseInt(args[0])];

		for(int i = 0; i < Integer.parseInt(args[0]); i++){

			dieRolls[i] = (int)(Math.random() * Integer.parseInt(args[1])) + 1; 
			System.out.println(dieRolls[i]);
			//float dieRoll = Math.random();
			//System.out.println(dieRoll + "\n" + dieRoll * Integer.parseInt(args[1]));
			//dieRolls[i] =  * Integer.parseInsInteger.parseInt(args[0])t(args[1]);
		}
	}
} 
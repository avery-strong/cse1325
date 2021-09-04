import java.util.Arrays;
import java.lang.Math;
import java.lang.*;

public class Roller{
	public static void main(String[] args){
		/*
			I was confused but I learned that .length will return the 
			size of the array and .length() returns the size of the 
			string
		*/
		if(args.length != 2){
			System.err.println("usage: java Roll [#dice] [#sides]");
			/*
				I felt System.exit(0) is redundant to use when I could 
				just else the rest of the code but thought it may be 
				interesting to implement
			*/
			System.exit(0);
		}
		
		int[] dieRolls = new int[Integer.parseInt(args[0])];
		int sum = 0;

		// Fill our array and increase sum
		for(int i = 0; i < Integer.parseInt(args[0]); i++){
			dieRolls[i] = (int)(Math.random() * Integer.parseInt(args[1])) + 1; 
			sum += dieRolls[i];
		}
			
		// Sort our array
		Arrays.sort(dieRolls);

		// Print our array
		for(int i : dieRolls)
			System.out.print(i + " ");

		// Print our sum and average
		System.out.println("\nSum: " + sum);
		System.out.println("Average: " + sum/Integer.parseInt(args[0]));
		
	}
} 
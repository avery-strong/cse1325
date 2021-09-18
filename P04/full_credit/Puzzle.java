/*
	This class represents the puzzle part of the game. 

	 

	The getSolution() method will return the solution attribute, e.g., to 
	print if the player guesses but misses the phrase.

	

	

	The solve method provides a proposed solution to the puzzle. It returns 
	true if the parameter matches solution, false otherwise.

	Iterating over each character in a string can be accomplished (at least) 
	two ways: A traditional 3-term for loop with String subscripting will 
	work, aka for(int i=0; i<s.size(); ++i) char c=s[i]; Perhaps more 
	convenient is a for-each loop, aka for(char c : s.toCharArray()) It's 
	that toCharArray() String method that you (and I) need to remember.
*/
public class Puzzle{
/*
	The constructor receives the phrase to be guessed as a parameter, 
	storing it in the solution attribute.
*/
	public Puzzle(String solution){ 
		this.solution = solution.toLowerCase(); 
		guesses = new boolean[solution.length()];
	}
/*
	The guess() method suggests one letter, and returns true if the letter 
	is a part of the phrase and false otherwise. 
	Use the guesses array to track which letters have been guessed - true 
	if guessed, false otherwise.
	Consider using the toLowerCase() method to avoid dealing with 
	capitalization.
*/
	public boolean guess(char c){ 
		/*
			toString() prints the solution using the guesses array as to 
			determine underscores. If a specific position in guesses is
			false toString() returns and underscore in that position.
			So when a letter is guessed correctly a false is changed
			to true in guesses so that letter is now printed correctly
		*/

		if(solution.contains(String.valueOf(c))){
			int i = solution.indexOf(c);
			while(i >= 0){
				guesses[i] = true;
				i = solution.indexOf(c, i + 1);
			}
			
			return true;
		}
		
		return false; 
	}
	public void solve(String proposedSolution){}
	public String getSolution(){ return solution; }
/*
	The toString() method should be overridden to return the phrase, 
	substituting an underscore for unguessed letters per the guesses 
	attribute. For example, if the phrase is "java rocks" and a and o have 
	been guessed, toString() would return "_a_a _o___".
*/
	@Override
	public String toString(){ 
		
		return "TEMPORARY RETURN"; 
	}

	private String solution;
	private boolean[] guesses;
}
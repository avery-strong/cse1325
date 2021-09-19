/*
	Iterating over each character in a string can be accomplished (at least) 
	two ways: A traditional 3-term for loop with String subscripting will 
	work, aka for(int i=0; i<s.size(); ++i) char c=s[i]; Perhaps more 
	convenient is a for-each loop, aka for(char c : s.toCharArray()) It's 
	that toCharArray() String method that you (and I) need to remember.
*/
public class Puzzle{

	// Constructor
	public Puzzle(String solution){ 
		this.solution = solution.toLowerCase(); 
		guesses = new boolean[solution.length()];

		// Set all integer values of spaces in guesses[] as true
		int i = solution.indexOf(' ');
		while(i >= 0){
			guesses[i] = true;
			i = solution.indexOf(' ', i + 1);
		}
	}

	/*
						GUESS
	*/ 
	public boolean guess(char c){ 
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
	/*
						SOLVE
	*/ 
	public boolean solve(String proposedSolution){
		if(solution.equals(proposedSolution.toLowerCase()))
			return true;

		return false;
	}
	public String getSolution(){ return solution; }

	@Override
	public String toString(){ 
		char[] solutionArray = new char[solution.length()];
		for(int i = 0; i < solution.length(); i++){
			if(guesses[i] == false)
				solutionArray[i] = '-';
			else
				solutionArray[i] = solution.charAt(i);
		}
		 
		String solutionReturn = String.valueOf(solutionArray);

		return solutionReturn;
	}

	private String solution;
	private boolean[] guesses;
}
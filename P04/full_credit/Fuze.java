public class Fuze{
	/*
						CONSTRUCTOR
	*/
	public Fuze(int time){ this.time = time; }
	/*
						BURN
	*/
	public boolean burn(){ 
		--time;
		
		if(time != 0)
			return true;

		return false; 
	}

	@Override
	public String toString(){ 
		System.out.print("\n    ");
		for(int i = 0; i < time; i++){
			System.out.print('-');
		}
		System.out.println(
			"*\n" 
			+ "   /\n"
			+ ",*,\n"
			+ "| |\n"
			+ "|_|\n");

		return ""; 
	}

	private int time;
}
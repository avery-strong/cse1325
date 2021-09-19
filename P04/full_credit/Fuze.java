/*
	This is a fun little class that represents a firecracker.

	The fuse length (attribute time) is set by the constructor, and gets 
	shorter by one segment (time is decremented) each time the burn() 
	method is called.

	The burn() method returns true as long as the firecracker hasn't popped 
	(time is greater than 0). When the fuse "burns down" to 0, the 
	firecracker pops and method burn() returns false. This indicates time 
	is up for guessing the phrase.

	Override the toString() method to show the firecracker and its fuse 
	length. Any representation is fine - this isn't an art class - but 
	don't hesitate to do something creative aka "ASCII Art"_.
	
	Displaying the "popping" firecracker (when time == 0) is optional.
*/

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

		return false; }
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
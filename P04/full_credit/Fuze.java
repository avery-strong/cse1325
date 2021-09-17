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
	public Fuze(int time){
		this.time = time;
	}
	public boolean burn(){ return true; }
	@Override
	public String toString(){ 
		System.out.print("    ");
		for(int i = 0; i < time; i++){
			System.out.print('-');
		}
		System.out.println(
			"*\n" 
			+ "   /\n"
			+ ",*,\n"
			+ "| |\n"
			+ "|_|\n");

		return "TEMPORARY STRING"; 
	}

	private int time;

}
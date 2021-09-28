import java.util.*; // Necessary for ArrayList
import java.util.Scanner;// Necessary for Scanner


public class Store{
	public static void cli(){
		Scanner in = new Scanner(System.in);
		double taxRate = 1.0825;
		boolean shopping = true;
		int menuChoice = 0;

		ArrayList<Product> products = new ArrayList<Product>();
		
		// Taxable products;
		products.add( new Taxed("Toilet Paper", 1.49));
		products.add( new Taxed("Hand Soap", 2.99));
		products.add( new Taxed("Flowers", 6.99));

		// Taxfree products
		products.add( new Taxfree("Apples", .75));
		products.add( new Taxfree("Bannas", .35));
		products.add( new Taxfree("Potatos", .40));

		// Item menu
		for(int i = 0; i < products.size(); i++)
			System.out.println(i+1 + ") " + products.get(i).toString());

		// Shoppint cart
		ArrayList<Product> cart = new ArrayList<Product>();

		System.out.println("\nChoose from the menu which item you would like to purchase, follewed by the quantity.");
		
		do{
			System.out.print("\nMenu Choice: ");
			menuChoice = in.nextInt();

			// Eat the new line
			in.nextLine();

			// menuChoice = 0
			if(menuChoice == 0){
				shopping = false;
				continue;
			}

			System.out.print("Quantity: ");

			// We take in our quantity during the .placeOrder() function call
			cart.add(products.get(menuChoice).placeOrder(in.nextInt()));

			// Eat the new line
			in.nextLine();
		}while(shopping);
		
		
	}
	public static void main(String[] args){
		cli();
	}
}


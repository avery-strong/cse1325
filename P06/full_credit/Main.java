public class Main{
	/*
		I believe this should satisfy testing. The most difficult part
		is being creative with the layout of a menu but everything
		works fine. I also wasnt certain on Cost so some values may
		not be coded for what we intend later on maybe I didnt read 
		carefully enough but have devoted a lot time to another exam 
		I have on Tuesday.
	*/
	
	public static void main(String[] args){
		Main main = new Main();
		cli();
	}

	public static void cli(){
		// Store test
		Store store = new Store("Avery's Store hahah");

		// Java test
		System.out.print("*****************\nSINGLE JAVA TEST\n*****************\n");
		Java java = new Java("A cup of Joe", 1.99, 1.99*1.0825, Darkness.blond);
		store.addProduct(java);
		System.out.print(store.toString(0));

		// Donut test
		System.out.print("\n\n*****************\nSINGLE DONUT TEST\n*****************\n");
		Donut donut = new Donut("Simpsons Donut", 1.99, 1.99*1.0825, Frosting.strawberry, Filling.unfilled, true);
		store.addProduct(donut);
		System.out.print(store.toString(1));

		// Full menu test
		System.out.print("\n\n*****************\nFULL MENU TEST\n*****************\n");
		System.out.print(store.toString());
	}
}
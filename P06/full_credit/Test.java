public class Test{
	
	public static void main(String[] args){
		Test test = new Test();
		cli();
	}

	public static void cli(){
		// Store test
		Store store = new Store("Avery's Store hahah");

		// Java test
		Java java = new Java("Caramel Macchiato", 4.99, 4.99*1.0825, Darkness.extreme);
		java.addShot(Shot.vanilla);
		java.addShot(Shot.hazelnut);
		store.addProduct(java);
		System.out.println(store.toString(0));

		// Donut test
		Donut donut = new Donut("Simpsons dount", 1.99, 1.99*1.0825, Frosting.strawberry, Filling.unfilled, true);
		store.addProduct(donut);
		System.out.println(store.toString(1));

		// Full menu test
		System.out.println(store.toString());
	}
}
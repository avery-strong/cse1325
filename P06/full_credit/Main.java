public class Main{
	public static void main(String[] args){
		Store store = new Store("Avery's Store hahah");
		Java java = new Java("Caramel Macchiato", 4.99, 4.99*1.0825, Darkness.extreme);
		store.addProduct(java);
		System.out.println(store.toString(0));
	}
}
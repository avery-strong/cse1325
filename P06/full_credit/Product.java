
abstract class Product{
	public Product(String name, double price, double cost){
		this.name = name;
		this.price = price;
		this.cost = cost;
	}
	public String name(){
		return name;
	}
	@Override
	public String toString(){
		return "Product: " + name + "\nPrice: " + price + "\nCost: " + cost;
	}
	protected String name;
	protected double price;
	protected double cost;
}
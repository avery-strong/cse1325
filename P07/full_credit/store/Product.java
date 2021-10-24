package store;

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
		return "\n" + name + "\t\t($" + price + ")";
	}
	protected String name;
	protected double price;
	protected double cost;
}
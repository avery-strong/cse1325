abstract class Product{
	public Product(String name, double unitCost){
		this.name = name;
		this.unitCost = unitCost;
	}
	abstract Product placeOrder(int quantity);
	public double price(){
		return unitCost;
	}
	@Override
	public String toString(){
		if(quantity > 0)
			return name + " (" + quantity  + " @ $" + unitCost + ')';

		return name + " (" + '$' + unitCost + ')';
	}

	protected String name;
	protected double unitCost;
	protected int quantity;
}
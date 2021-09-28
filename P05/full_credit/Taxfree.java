/*
	The Taxfree class represents a product immune to sales tax.  

	As such, it simply needs a constructor to chain to super (since constructors never inherit) 
	and implementations for the superclass abstract methods placeOrder and price. 

	The price is calculated as simply quantity x unitCost.
*/

public class Taxfree extends Product{
	public Taxfree(String name, double cost){
		super(name, cost);
	}
	@Override
	public Product placeOrder(int quantity){
		this.quantity = quantity;

		Taxfree a = new Taxfree(this.name, this.unitCost);

		return a;
	}
	@Override
	public final double price(){
		return quantity * unitCost;
	}
}
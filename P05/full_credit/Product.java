/*
	The Product class represents both a  type  of item for sale on the store shelf or website, 
	and also a specificy quantity  of the item in a shopper's cart. 

	It is instanced for the store shelf or website via the constructor, 
	using the supplied name and unit cost. 

	In this case, its toString shows it like this: "Cheese ($0.99)" 
	To put one or more of these products in the shopper's cart, call the 
	object's placeOrder method with the quantity to be ordered. 

	placeOrder returns a new object with the same product name and unit 
	cost, but with quantity non-zero. 

	toString shows a non-zero quantity product like this: "Cheese (2 @ $0.99)"
*/

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
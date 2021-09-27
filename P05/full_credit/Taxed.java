/*
	The Taxed class represents a product for which sales tax must be collected at the local sales  
	tax rate. 

	Since this rate is the same for all taxed products, we have a  static  tax attribute to 
	store it and a  static setSalesTaxRate method to change it. 

	The placeOrder overridden method is identical to Taxfree (other than returning a Taxed 
	object instead of a Taxfree object). 

	The price is calculated as quantity x unitCost x (1+tax). 

	Ensure your price has no more than 2 decimal places per US custom!
*/

public class Taxed extends Product{
	public Taxed(String name, double cost){
		super(name, cost);
	}
	public void setSales(double salesTaxRate){

	}
	/*@Override
	public Product placeOrder(int quantity){
		super(quantity);

		return product;
	}*/
	@Override
	public double price(){
		return quantity * unitCost * (1 + tax);
	}

	private double tax;
}
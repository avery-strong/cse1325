package store;

import java.util.*;

public class Store{
	public Store(String storeName){ this.storeName = storeName; }
	public String storeName(){ return storeName; }
	public void addProduct(Product product){ products.add( product ); }
	public int numberOfProcuts(){ return products.size(); }
	// Single Produt
	public String toString(int productIndex){ return products.get(productIndex).toString(); }
	// Full Menu
	@Override
	public String toString(){ 
		StringBuilder str = new StringBuilder();

		for(Product p : products){
			str.append(p.toString());
		}

		String s = str.toString();

		return s; 
	}

	protected String storeName;
	// Technically our menu
	protected ArrayList<Product> products = new ArrayList<>();
}
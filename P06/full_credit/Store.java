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
	public String toString(){ return ""; }

	protected String storeName;
	protected ArrayList<Product> products = new ArrayList<>();
}
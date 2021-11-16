package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;

public class Order{
	public Order(Customer customer, Server server){
		this.customer = customer;
		this.server = server;
		this.products = new HashMap<>();
		id = nextId++;
	}

	public Order(BufferedReader in) throws IOException{
		this.products = new HashMap<>();
	}

	public void save(BufferedWriter out) throws IOException{

	}

	public int getId(){ return id; }

	public void addProduct(int quantity, Product product){
		products.put(product, quantity);
	}

	@Override
	public String toString(){
		String result = "Order " + id 
				+ '\n' 
				+ "Customer: " + customer 
				+ '\n'
				+ "Server: " + server 
				+ '\n';
		for(Product p : products.keySet()){
			result += products.get(p) + " " + p.toString() + '\n';
		}
		return result;
	}

	private int id;
	private static int nextId;
	private Customer customer;
	private Server server;
	private HashMap<Product, Integer> products;
}
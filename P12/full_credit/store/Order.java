package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Order{
	public Order(Customer customer, Server server){
		this.customer = customer;
		this.server = server;
		this.products = new HashMap<>();
		id = nextId++;
	}

	public Order(String buffer, Store store) throws IOException{
		this.products = new HashMap<>();

		String token;
		int productQuantity = 0;
		Person person;
		Product product;
		
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		
		multiTokenizer.nextToken();		
		this.id = Integer.parseInt(multiTokenizer.nextToken());
		this.nextId = Integer.parseInt(multiTokenizer.nextToken());
		token = multiTokenizer.nextToken();

		person = store.getPerson(token);
		customer = (Customer)person;

		token = multiTokenizer.nextToken();

		person = store.getPerson(token);
		server = (Server)person;

		// Parse multiTokenizer for first type token
		int tokenCount = multiTokenizer.countTokens();

		for(int i = 0; i < tokenCount/2; i++){
			productQuantity = Integer.parseInt(multiTokenizer.nextToken());
			token = multiTokenizer.nextToken();
			
			product = store.getProduct(token);

			products.put(product, productQuantity);
		}
	}

	public void addProduct(int quantity, Product product){ products.put(product, quantity); }

	public int getId(){ return id; }

	public int numberOfProducts(){ return products.size(); }

	public void save(BufferedWriter out) throws IOException{
		out.write('\n' + "" 
					+ "order" + '|' 
					+ id + '|' 
					+ nextId + '|'
					+ customer.getCustomerName() + '|'
					+ server.getServerName()); 
		//customer.save(out);
		//server.save(out);
		for(Product key : products.keySet()){
			out.write("" + '|' + products.get(key) + '|' + key.name());
		}
	}

	@Override
	public String toString(){
		String result = "Order " 
				+ id 
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
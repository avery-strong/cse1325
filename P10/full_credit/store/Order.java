package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;

public class Order{
	public Order(Customer customer, Server server){
		this.customer = customer;
		this.server = server;
	}

	public Order(BufferedReader in) throws IOException{

	}

	public void save(BufferedWriter out) throws IOException{

	}

	public int getId(){
		int i = 0;
		return i;
	}

	public void addProduct(int quantity, Product product){

	}

	@Override
	public String toString(){
		return "";
	}

	private int id;
	private Customer customer;
	private Server server;
	private HashMap<Product, Integer> products;
}
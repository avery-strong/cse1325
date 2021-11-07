package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer extends Person{
	public Customer(String name, String phone){
		super(name, phone);
	}

	public Customer(BufferedReader in) throws IOException{
		super(in);
	}

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write("" + name + "\n");
		out.write("" + phone + "\n");
	}
}


/*
	Since we will eventually also track other people like servers and managers, first create 
	a superclass called Person to encapsulate their name and phone number. 

	Customer extends People, overriding the save method (to write its ID first) and 
	providing the usual two constructors (for initial construction and constructing from a file).

*/
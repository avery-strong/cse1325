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
		out.write("" + "customer" + '\n');
		out.write("" + name + '\n');
		out.write("" + phone + '\n');
	}
}
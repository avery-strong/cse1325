package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer extends Person{
	public Customer(String name, String phone){
		super(name, phone);
	}

	public Customer(String buffer, BufferedReader in) throws IOException{
		super(buffer, in);
	}

	public String getCustomerName(){ return name; }

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write('\n' + "" + "customer"+ '|' + name + '|' + phone);
	}
}
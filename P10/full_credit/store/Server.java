package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Server extends Person{
	public Server(String name, String phone, String ssn){
		super(name, phone);
		this.ssn = ssn;
	}

	public Server(BufferedReader in) throws IOException{
		super(in);
		this.ssn = in.readLine();
	}

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write("" + "server" + '\n');
		out.write("" + name + '\n');
		out.write("" + phone + '\n');
		out.write("" + ssn + '\n');
	}

	@Override
	public String toString(){ 
		return name 
				+ "\n" 
				+ "\t" + "Phone: " + phone 
				+ "\n" 
				+ "\t" + "SSN: " + ssn + ")"; 
	}

	// Attributes
	private String ssn;
}
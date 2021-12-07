package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Server extends Person{
	public Server(String name, String phone, String ssn){
		super(name, phone);
		this.ssn = ssn;
	}

	public Server(String buffer, BufferedReader in) throws IOException{
		super(buffer, in);

		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		multiTokenizer.nextToken();		// Read "server"
		multiTokenizer.nextToken();		// Read name
		multiTokenizer.nextToken();		// Read phone

		this.ssn = multiTokenizer.nextToken();
	}

	public String getSocial(){ return ssn; }

	@Override
	public void save(BufferedWriter out) throws IOException{
		out.write('\n' + "" + "server" + '|' + name + '|' + phone + "|" + ssn);
	}

	@Override
	public String toString(){ 
		return name + " (Phone: " + phone + ", SSN: " + ssn + ")"; 
	}

	// Attributes
	private String ssn;
}
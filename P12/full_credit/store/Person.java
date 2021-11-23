package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;


public class Person{
	public Person(String name, String phone){
		this.name = name;
		this.phone = phone;
	}

	public Person(String buffer, BufferedReader in) throws IOException{
		StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
		// Reads the first token which is the Person type 
		multiTokenizer.nextToken();	

		this.name = multiTokenizer.nextToken();
		this.phone = multiTokenizer.nextToken();
	}

	public String getName(){ return name; }

	public void save(BufferedWriter out) throws IOException{
		out.write('\n' + "" + name + '|' + phone);
	}

	@Override
	public String toString(){
		return name + " (Phone: " + phone + ")"; 
	}

	protected String name;
	protected String phone;
}

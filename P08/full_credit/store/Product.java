package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Product {
    public Product(String name, double price, double cost) {
        this.name  = name;
        this.price = price;
        this.cost  = cost;
    }
    public Product(BufferedReader in) throws IOException{
        this(name, price, cost);
        name = in.readLine();
        price = (double)in.readLine();
        cost = (double)in.readLine();

        
    }
    public void save(BufferedWriter out) throws IOException{
        out.write("" + name + '\n');
        out.write("" + price + '\n');
        out.write("" + cost + '\n');
    }
    public String name() {return name;}
    @Override
    public String toString() {
        return name + " ($" + price + ", ";
    }

    protected String name;
    protected double cost;
    protected double price;
}

package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Product {
    public Product(String name, double price, double cost) {
        this.name  = name;
        this.price = price;
        this.cost  = cost;
    }

    public Product(String buffer, BufferedReader in) throws IOException{
        StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
        
        // Reads the first token which is the Product type
        multiTokenizer.nextToken();     

        this.name = multiTokenizer.nextToken();
        this.price = Double.parseDouble(multiTokenizer.nextToken());
        this.cost = Double.parseDouble(multiTokenizer.nextToken());
    }

    public Product getProduct(){ return this; }

    public void save(BufferedWriter out) throws IOException{
        out.write('\n' + "" + "product" + '|' + name + '|' + price + '|' + cost);
    }

    public String getName(){ return name; }
    public double getCost(){ return cost; }
    public double getPrice(){ return price; }

    @Override
    public String toString() {
        return name + " ($" + price + ", ";
    }

    // Attributes
    protected String name;
    protected double cost;
    protected double price;
}

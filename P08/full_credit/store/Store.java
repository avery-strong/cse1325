package store;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store {
    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>();
    }
    public Store(BufferedReader in) throws IOException{
        this.storeName = in.readLine();
        this.products = new ArrayList<>();
    }
    public void save(BufferedWriter out) throws IOException{
        out.write("" + storeName + '\n');
    }
    String name() {return storeName;}
    public void addProduct(Product product) {
        this.products.add(product);
    }
    public int numberOfProducts() {
        return products.size();
    }
    // Single Product
    public String toString(int index) {
        return products.get(index).toString();
    }
    // Full Menu
    @Override
    public String toString() {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<products.size(); ++i) {
            result += i + ") " + products.get(i) + "\n";
        }
        return result;
    }
    public Product getProduct(int i){
        return products.get(i);
    }
    private String storeName;
    private ArrayList<Product> products;
}

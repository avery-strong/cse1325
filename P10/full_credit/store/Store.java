package store;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store {
    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>();
        this.people = new ArrayList<>();

    }

    public Store(BufferedReader in) throws IOException{
        this.storeName = in.readLine();
        in.readLine();
        this.products = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    public void save(BufferedWriter out) throws IOException{
        out.write("" + storeName + '\n');
        out.write("" + people.size() + '\n');
    }

    String name() { return storeName; }

    /****************************************
                Product Methods
    ****************************************/

    public Product getProduct(int i){ return products.get(i); }

    public void addProduct(Product product){ this.products.add(product); }

    public int numberOfProducts(){ return products.size(); }

    // Single Product
    public String toString(int index) { return products.get(index).toString(); }

    // Full Menu
    @Override
    public String toString() {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<products.size(); ++i) {
            result += i + ") " + products.get(i) + "\n";
        }
        return result;
    }

    /****************************************
                Person Methods
    ****************************************/

    public void addPerson(Person person){ this.people.add(person); }

    public Person getPerson(int i){ return people.get(i); }

    public int numberOfPeople(){ return people.size(); }

    // Single person
    public String personToString(int i){ return people.get(i).toString(); }

    // Full people list
    public String peopleToString() {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<people.size(); ++i) {
            if(people.get(i) instanceof Server)
                result += i + ") " + "Server: " + people.get(i) + "\n";
            else
                result += i + ") " + "Customer: " + people.get(i) + "\n";

        }
        return result;
    }

    /****************************************
                Order Methods
    ****************************************/

    public void addOrders(Order order){ this.orders.add(order); }

    //public Orders[] getOrders(){ return Order[] }

    public String ordersToString(){
        return "";
    }

    // Attributes
    protected String storeName;
    protected ArrayList<Order> orders;
    protected ArrayList<Person> people;
    protected ArrayList<Product> products;
}
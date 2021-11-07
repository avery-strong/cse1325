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
        this.products = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    public void save(BufferedWriter out) throws IOException{
        out.write("" + storeName + '\n');
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
            result += i + ") " + people.get(i) + "\n";
        }
        return result;
    }

    // Attributes
    private String storeName;
    private ArrayList<Product> products;
    private ArrayList<Person> people;
}

/*
    Add an ArrayList<Person> attribute to Store, with methods analogous to those for 
    Product to enable access to Person objects. 

    A (unified) dialog is then needed in Mainwin (or your equivalent Swing class) to create 
    new Customers via Create > Customer and the associated button, to be added via the 
    Store.addPerson method.

    To class Store, add a private ArrayList of type Person and methods 
    addPerson (analogous to addProduct), 
    numberOfPeople (analogous to numberOfProducts), 
    personToString(index) (analogous to toString(index), 
    and peopleToString (analogous to toString).
*/

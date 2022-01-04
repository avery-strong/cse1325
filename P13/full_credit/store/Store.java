package store;

import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Store {
    public Store(String storeName) {
        this.storeName = storeName;
        this.orders = new ArrayList<>();
        this.products = new ArrayList<>();
        this.people = new ArrayList<>();

    }

    public Store(String buffer, BufferedReader in) throws IOException{
        StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
        this.storeName = multiTokenizer.nextToken();
        this.orders = new ArrayList<>();
        this.products = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    public void save(BufferedWriter out) throws IOException{
        out.write("" + storeName + '|' + people.size());
    }

    public String getName() { return storeName; }

    /****************************************
                Product Methods
    ****************************************/

    public Product getProduct(int i){ return products.get(i); }

    public Product getProduct(String str){ 
        Product p;
        int i;
        for(i = 0; i < people.size(); i++)
            if(str.equals(getProduct(i).getName())) break; 
        
        p = products.get(i);

        return p;
    }

    public Object[] getProducts(){
        Object[] options = new Object[products.size()];

        for(int i = 0; i < products.size(); i++){
            options[i] = products.get(i);
        }
        return options;
    }

    public void addProduct(Product product){ this.products.add(product); }
    public void removeProduct(Product product){ this.products.remove(product); }

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

    public Person getPerson(String str){
        Person p;
        int i;
        for(i = 0; i < people.size(); i++)
            if(str.equals(getPerson(i).getName())) break;
        
        p = people.get(i);

        return p;
    }

    public Object[] getPeople(){
        Object[] options = new Object[people.size()];

        for(int i = 0; i < people.size(); i++){
            options[i] = people.get(i);
        }
        return options;
    }

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

    public Order getOrder(int i){ return orders.get(i); }

    public void addOrders(Order order){ this.orders.add(order); }

    public int numberOfOrders(){ return orders.size(); }

    public String ordersToString(){
        String result = "Current Orders " + '\n' + '\n';
        for(int i = 0; i < orders.size(); i++){
            result += orders.get(i);
        }
        return result;
    }

    public void removeCurrentOrder(){ this.orders.remove(orders.size() - 1); }

    // Attributes
    protected String storeName;
    protected ArrayList<Order> orders;
    protected ArrayList<Person> people;
    protected ArrayList<Product> products;
}
package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Donut extends Product {
    public Donut(String name, double price, double cost, Frosting frosting, Filling filling, boolean sprinkles) {
        super(name, price, cost);
        this.frosting = frosting;
        this.filling = filling;
        this.sprinkles = sprinkles;
        if(sprinkles && frosting == Frosting.Unfrosted)
            throw new IllegalArgumentException("Unfrosted Donut cannot have sprinkles");
    }
    public Donut(BufferedReader in){
        this(name, price, cost, frosting, filling, sprinkles);
        name = in.readLine();
        price = (double)in.readLine();
        cost = (double)in.readLine();
        frosting = out.readLine();
        filling = out.readLine();
        sprinkles = in.readLine();

        
    }

    public void save(BufferedWriter out){
        out.write("" + name + '\n');
        out.write("" + price + '\n');
        out.write("" + cost + '\n');
        out.write("" + frosting + '\n');
        out.write("" + filling + '\n');
        out.write("" + sprinkles + '\n');
    }

    @Override
    public String toString() {
         return name + " (" 
              + ((frosting != Frosting.Unfrosted) ? "frosted with " : "") + frosting
              + ((filling != Filling.Unfilled) ? " filled with " : " ") + filling
              + ((sprinkles) ? " add sprinkles" : "")
              + ") $" + price;
    }

    Frosting frosting;
    Filling filling;
    boolean sprinkles;
}

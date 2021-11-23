package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Donut extends Product {
    public Donut(String name, double price, double cost, Frosting frosting, Filling filling, boolean sprinkles) {
        super(name, price, cost);
        this.frosting = frosting;
        this.filling = filling;
        this.sprinkles = sprinkles;
        if(sprinkles && frosting == Frosting.Unfrosted)
            throw new IllegalArgumentException("Unfrosted Donut cannot have sprinkles");
    }

    public Donut(String buffer, BufferedReader in) throws IOException{
        super(buffer, in);
        StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
        multiTokenizer.nextToken();     // Read type
        multiTokenizer.nextToken();     // Read name
        multiTokenizer.nextToken();     // Read price
        multiTokenizer.nextToken();     // Read cost

        this.frosting = Frosting.valueOf(multiTokenizer.nextToken());
        this.filling = Filling.valueOf(multiTokenizer.nextToken());
        this.sprinkles = Boolean.parseBoolean(multiTokenizer.nextToken());
    }

    @Override
    public void save(BufferedWriter out) throws IOException{
        out.write('\n' + "" + "donut" 
                     + '|' + name 
                     + '|' + price 
                     + '|' + cost 
                     + '|' + frosting 
                     + '|' + filling 
                     + '|' + sprinkles); 
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

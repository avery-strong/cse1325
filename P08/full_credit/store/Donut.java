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
    public Donut(BufferedReader in) throws IOException{
        super(name, price, cost);
        Object objFrost, objFill, objSprink;

        name = in.readLine();
        price = Double.parseDouble(in.readLine());
        cost = Double.parseDouble(in.readLine());
        objFrost = in.readLine();
        frosting = (Frosting)objFrost;
        objFill = in.readLine();
        filling = (Filling)objFill;
        sprinkles = Boolean.parseBoolean(in.readLine());        
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

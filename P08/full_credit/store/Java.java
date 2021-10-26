package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;

public class Java extends Product {
    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>();
    }
    public Java(BufferedReader in) throws IOException{
        super(in);
        this.shots = new ArrayList<>();
        String strShot;

        this.darkness = Darkness.valueOf(in.readLine());
        strShot = in.readLine();
        while(!strShot.equals("donut") && !strShot.equals("java") && !strShot.equals(null)){
            this.shots.add(Shot.valueOf(strShot));
            // I can see how this would fail
            in.mark(100);
            strShot = in.readLine();
        }

        in.reset();

    }
    public void save(BufferedWriter out) throws IOException{
        // Buffer
        out.write("" + "java" + '\n');
        // Product
        out.write("" + name + '\n');
        out.write("" + price + '\n');
        out.write("" + cost + '\n');
        // Java
        out.write("" + darkness + '\n');
        for(Shot s : shots){
            out.write("" + s + '\n');
        }
    }
    public void addShot(Shot shot) {
        shots.add(shot);
    }
    @Override
    public String toString() {
        String result = name + " (" + darkness + " with ";
        if (shots.size() == 0) result += "no shots";
        else {
            String separator = "";
            for(Shot s : shots) {
                result += separator + s; 
                separator = ", ";
            }
        }
        result += ") $" + price;
        return result;
    }

    Darkness darkness;
    ArrayList<Shot> shots;
}

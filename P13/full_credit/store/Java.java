package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java extends Product {
    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>();
    }

    public Java(String buffer, BufferedReader in) throws IOException{
        super(buffer, in);
        StringTokenizer multiTokenizer = new StringTokenizer(buffer, "|");
        multiTokenizer.nextToken();     // Read type
        multiTokenizer.nextToken();     // Read name
        multiTokenizer.nextToken();     // Read price
        multiTokenizer.nextToken();     // Read cost

        this.darkness = Darkness.valueOf(multiTokenizer.nextToken());
        this.shots = new ArrayList<>();

        int count = multiTokenizer.countTokens();

        for(int i = 0; i < count; i++)
            this.shots.add(Shot.valueOf(multiTokenizer.nextToken()));
    }

    @Override
    public void save(BufferedWriter out) throws IOException{
        out.write('\n' + "" + "java" 
                     + '|' + name 
                     + '|' + price 
                     + '|' + cost 
                     + '|' + darkness);

        for(Shot s : shots){
            out.write("" + '|' + s);
        }
    }

    public void addShot(Shot shot){ this.shots.add(shot); }
    public int numberOfShots(){ return shots.size(); }
    public Darkness getDarkness(){ return darkness; }
    public Object[] getShots(){
        Object[] shotsArr = shots.toArray();

        return shotsArr;
    }

    public Shot getShot(int i){ return shots.get(i); }

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

    // Attributes
    Darkness darkness;
    ArrayList<Shot> shots;
}

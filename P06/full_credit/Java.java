import java.util.*;

public class Java extends Product{
	public Java(String name, double price, double cost, Darkness darkness){
		super(name, price, cost);
		this.darkness = darkness;
	}
	public void addShot(Shot shot){ 
		shots.add(shot);
	}
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		for(Shot s : shots){
			str.append(s.toString());
			str.append(", ");
		}
		String s = str.toString();

		return super.toString() + "\nDarkness: " + this.darkness + "\nShots: " + s;
	}
	protected Darkness darkness;
	protected ArrayList<Shot> shots = new ArrayList<>();
}
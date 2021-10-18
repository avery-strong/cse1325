package store;
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
		return super.toString() + "\n\t" + this.darkness + " roast";
	}
	protected Darkness darkness;
	protected ArrayList<Shot> shots = new ArrayList<>();
}
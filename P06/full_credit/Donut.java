public class Donut extends Product{
	public Donut(String name, double price, double cost, Frosting frosting, Filling filling, boolean sprinkles){
		super(name, price, cost);
		this.frosting = frosting;
		this.filling = filling;
		this.sprinkles = sprinkles;
	}
	@Override
	public String toString(){
		if(sprinkles)
			return super.toString() + "\n\t" + this.frosting +  " frosting, " + this.filling + ", with sprinkles";

		return super.toString() + "\n\t" + this.frosting +  " frosting, " + this.filling + ", without sprinkles";
	}
	protected Frosting frosting;
	protected Filling filling;
	protected boolean sprinkles;
}
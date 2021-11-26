import java.util.ArrayList;
import java.text.NumberFormat;

public class Primes{
	public Primes(int numThreads){
		this.numThreads = numThreads;
		this.primes = new ArrayList<>();
	}

	public Primes findPrimes(int lower, int upper){
		if(lower == 0 || lower == 1) lower = 2;
		for (int i=lower; i<=upper; i++)
			if(isPrime(i)) primes.add(i);
		
		return this;
	}

	public int numberOfPrimes(){ return primes.size(); }
	
	protected boolean isPrime(int number){
		for (int i=2; i<=number/2; i++)
        	if (number%i == 0) return false;
	   		
		return true;
	}

	public Integer[] toArray(){
		Integer[] arr = primes.toArray(new Integer[primes.size()]);

		return arr;
	}

	public static void main(String[] args) {
        int numThreads = 1;
        int lower = 0;
        int upper = 100; // defaults
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }
        
        Primes primes = new Primes(numThreads); // Search using one thread
        int sumOfPrimes = 0;
        for(int prime : primes.findPrimes(lower, upper).toArray()){
        	System.out.println(prime);
            sumOfPrimes += prime;
        }
        System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between " 
                         + lower + " and " 
                         + upper + " is " 
                         + NumberFormat.getIntegerInstance().format(sumOfPrimes));
    }

	private int numThreads;
	private ArrayList<Integer> primes;
}
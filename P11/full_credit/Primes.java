import java.util.ArrayList;
import java.text.NumberFormat;

public class Primes implements Runnable{
	public Primes(int numThreads){
		this.numThreads = numThreads;
		this.primes = new ArrayList<>();
	}

	public Primes(int numThreads, int lower, int upper){
		this.numThreads = numThreads;
		this.lower = lower;
		this.upper = upper;
		this.threadLower = lower;
		this.primes = new ArrayList<>();
	}

	protected void addPrimes(int lower, int upper){
		if(lower == 0 || lower == 1) lower = 2;		// 0 and 1 are not considered primes
		for (int i=lower; i<=upper; i++){
			if(isPrime(i)) primes.add(i);
		}
	}
	
	public Primes findPrimes(int lower, int upper){
		int[] slices = new int[numThreads];
		Thread[] threads = new Thread[numThreads];

		for(int i = 0; i < numThreads; i++){
			slices[i] = upper/(numThreads) * (i+1);
			threadUpper = slices[i];

			threads[i] = new Thread(this);
			threads[i].start();
			/* 
				I have a hard time understanding if this is still considered
				as join seemingly stops another thread frome launching until
				the first is finished which seems to defated the purpose but
				the problems I was having were solved whin I used join()
			*/
			try{
				threads[i].join();
			}catch(Exception e){
				System.out.println("I dont know that to do with this");
			}

			threadLower = lower + threadUpper;
		}	

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

	public void run(){
		addPrimes(threadLower, threadUpper);
	}

	public static void main(String[] args){
        int numThreads = 1;
        int lower = 1;
        int upper = 10000; // defaults
        int sumOfPrimes = 0;
        
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }

        Primes primes = new Primes(numThreads, lower, upper);

        for(int prime : primes.findPrimes(lower, upper).toArray())
        	sumOfPrimes += prime;
           
       System.out.println("Sum of the " + primes.numberOfPrimes() + " primes between " 
                         + lower + " and " 
                         + upper + " is " 
                         + NumberFormat.getIntegerInstance().format(sumOfPrimes));
    }

	private int numThreads;
	private int lower;
	private int upper;
	private int threadUpper;
	private int threadLower;
	private ArrayList<Integer> primes;
}
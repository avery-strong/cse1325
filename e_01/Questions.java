enum Questions{
	q01("___ One advantage of a Java ArrayList over a traditional array is"), 
	q02("___ Java handles multiple inheritance using"), 
	q03("___ The main method in class Gradebook can access which method in class Grade?"), 
	q04("___ The default destructor for class Account in Java is declared as"), 
	q05("___ To compare the value of int a and int b in Java, write"), 
	q06("___ To throw an exception for bad dates, write"), 
	q07("___ Of the four arrows shown in the diagram above, the only one NOT a valid UML class relationship is"), 
	q08("___ In Java, we would convert a String s to all upper case letters using"), 
	q09("___ To invoke target \"clean\" in the local build.xml from the bash shell, type"), 
	q10("___ Once class Animal has been declared, it may be instanced using"), 
	q11("___ In the UML, an abstract method is shown with"), 
	q12("___ The Java default constructor for class BigInt can chain to an overloaded constructor using"), 
	q13("___ Java is"), 
	q14("___ In the UML, a class is represented by"), 
	q15("___ To print \"Hello, world!\" to the console in Java, write");

	private Questions(String question){ this.question = question; }
	public String getQuestion(){ return this.question; }
	private String question;
}

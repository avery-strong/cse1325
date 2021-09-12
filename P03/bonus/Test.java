public class Test{
	public static void main(String[] args){
		Student s = new Student("avery");
		/* 
			TEST #1: 
			Verify that the name provided to the constructor is correctly 
			returned by the getName() method.
		*/
		if(s.getName().equals("avery") != true)
			System.err.println("FAIL: .getName() does not return avery");

		/*
			TEST #2:
			Verify that if no exam grades have been provided via method 
			addExam(double), method average() returns 100.
		*/
		if(s.average() != 100){
			// .addExam has yet to be called so .average() should return 100
			System.err.println("FAIL: .average() does not return 100");
		}
		/*
			TEST #2:
			Verify that when 2 or more exam grades have been provided 
			via method addExam(double), method average() returns the 
			correct average of the exam grades.
		*/
		s.addExam(74);
		s.addExam(42);
		if(s.average() != 58){
			System.err.println("FAL: .average() does not return 58");
		}

	}
}
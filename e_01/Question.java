import java.util.StringTokenizer;

public class Question{
	public Question(String question, String answer, Character correctAns){
		this.question = question;
		this.correctAns = correctAns;

		StringTokenizer multiTokenizer = new StringTokenizer(answer, ",");

		for(int i = 0; i < 4; i++){
			this.answers[i] = multiTokenizer.nextToken();
		}
	}
	@Override
	public String toString(){
		System.out.println(question);

		for(int i = 0; i < answers.length; i++){
			System.out.print(
				"\n"
				+ "        "
				+ (char)(65 + i)
				+ ". "
				+ answers[i]);
		}
		return "";
	}
	public Character getCorrect(){ return this.correctAns; }

	private String question;
	private Character correctAns;
	private String[] answers = new String[4];
}

public class Question{
	public Question(String question, String answer){
		this.question = question;
		this.answer = answer;
	}
	@Override
	public String toString(){
		return question;
	}
	private String question;
	private String answer;
}
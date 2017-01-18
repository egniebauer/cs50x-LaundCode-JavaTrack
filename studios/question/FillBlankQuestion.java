package question;

public class FillBlankQuestion extends Question {
	
	//Fields
	
	//Constructor(s)
	public FillBlankQuestion(String question, String correctAnswer) {
		super(question, correctAnswer);
	}

	@Override
	public String toString() {
		return "FillBlankQuestion [question=" + question + ", correctAnswer=" + correctAnswer + "]";
	}
	
}

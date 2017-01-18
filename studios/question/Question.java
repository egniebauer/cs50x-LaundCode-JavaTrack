package question;

public class Question {
	
	//Fields
	protected String question;
	protected String correctAnswer;
	
	//Constructor(s)
	public Question(String question, String correctAnswer) {
		this.question = question;
		this.correctAnswer = correctAnswer;
	}
	
	//Getters & Setters, toString
	public String getQuestion() {
		return question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public String toString() {
		return String.format("Question: [question: %s, correctAnswer: %s]", this.question, this.correctAnswer);
	}
	
	//Methods
	
}

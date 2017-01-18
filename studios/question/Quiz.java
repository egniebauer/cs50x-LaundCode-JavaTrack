package question;

public class Quiz {
	
	QuizList quizList;
	int score;
	
	public Quiz() {
		// TODO Auto-generated constructor stub
	}
	
	public void displayQuestion(QuizList quizList) {
		int optNum = 1;
		
		while (true) {
			System.out.println(optNum + ". " + this.quizList.toString());
			optNum++;
		}
	}
	public void displayOptions() {
		
	}
	public void receiveAnswer() {
		
	}
	public void checkAnswer() {
		
	}
	public void displayScore() {
		
	}
}

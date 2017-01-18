package question;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizList {
	
	//Fields
	private ArrayList<Question> quizList;
	private Scanner in;
	
	//Constructor(s)
	public QuizList() {
		this.quizList = new ArrayList<Question>();
		this.in = new Scanner(System.in);
	}
	
	//Main
	public static void main(String[] args) {
		
		int x = 0;
		QuizList newQuiz = new QuizList();
		
		do {
			x = newQuiz.buildQuiz();
			newQuiz.processBuild(x);
		} while (x != 5);
	}
	
	//Menu Methods
	public int buildQuiz() {
		// display menu
		System.out.println("Welcome to making your quiz!");
		System.out.println("1. Add a new question");
		System.out.println("2. Display list of current questions");
		System.out.println("3. Remove a question");
		System.out.println("4. Run quiz");
		System.out.println("5. Exit\n");
		
		// receive input from user
		int choice = in.nextInt();
		
		// validate user's choice
		while (choice < 0 || choice > 5) {
			System.out.println("Sorry, that wasn't an option. Please try again:");
			choice = in.nextInt();
		}
		return choice;
	}
	
	public void processBuild(int choice) {
		//int choice = buildQuiz();
		if (choice == 1) {
			createQuestion();
		}
		else if (choice == 2) {
			displayQuestions();
		}
		else if (choice == 3) {
			removeQuestion();
		}
		else if (choice == 4) {
			runQuiz();
		}
	}
	
	//Processing Methods
	public int questionType() {
		System.out.println("Select the type of question:");
		System.out.println("\t1. Multiple choice");
		System.out.println("\t2. Fill in the blank");
		
		// receive input from user
		int questionType = in.nextInt();
		
		// validate user's choice
		while (questionType < 0 || questionType > 2) {
			System.out.println("Sorry, that wasn't an option. Please try again:");
			questionType = in.nextInt();
		}
		return questionType;
	}
	
	void createQuestion() {
		int questionType = questionType();
		
		if (questionType == 1) {
			createMultipleChoice();
		}
		else if (questionType == 2) {
			createFillBlank();
		}
	}
	
	private void createMultipleChoice() {
		// Retrieve necessary inputs for fields
		System.out.println("Enter the question.");
		@SuppressWarnings("unused")
		String consume = in.nextLine();
		String question = in.nextLine();
		
		System.out.println("Enter the correct answer.");
		String answer = in.nextLine();
		
		MultipleChoiceQuestion newQuestion = new MultipleChoiceQuestion(question, answer);
		newQuestion.addWrongChoices();
		
		addNewQuestion(newQuestion);
		System.out.println("Done! The question has been successfully added.");
	}
	
	private void createFillBlank() {
		System.out.println("Enter the question. Include \"_____\" for your blank.");
		@SuppressWarnings("unused")
		String consume = in.nextLine();
		String question = in.nextLine();
		
		System.out.println("Enter the correct answer.");
		String answer = in.nextLine();
		
		FillBlankQuestion newQuestion = new FillBlankQuestion(question, answer);
		addNewQuestion(newQuestion);
		System.out.println("Done! The question has been successfully added.");
	}

	private void addNewQuestion(Question newQuestion) {
		if (this.quizList.contains(newQuestion)) {
			System.out.println("This question already exists.");
		}
		else {
			this.quizList.add(newQuestion);
		}
	}

	public void displayQuestions() {
		int optNum = 1;
		
		for (Question question : this.quizList) {
			System.out.println(optNum + ". " + question.toString());
			optNum++;
		}
	}
	
	public int selectQuestion() {		
		// receive user selection
		int selection = in.nextInt();

		// verify option choice
		while (selection < 1 || selection > (this.quizList.size() + 1)) {
			System.out.println("Invalid selection. Please try again");
			selection = in.nextInt();
		}
		
		// return selection as array's index
		return selection - 1;
	}

	public void removeQuestion() {
		System.out.println("Which question would you like removed?");
		displayQuestions();

		int index = selectQuestion();
		
		this.quizList.remove(index);
		System.out.println("The questions for this quiz are now:");
		displayQuestions();
	}

	public void runQuiz() {
		System.out.println("Not implemented");
	}	
}

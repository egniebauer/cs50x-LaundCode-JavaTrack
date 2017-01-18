package question;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
	
	//Fields
	private ArrayList<String> wrongChoices;
	private Scanner in;
	
	//Constructor(s)
	public MultipleChoiceQuestion(String question, String correctAnswer) {
		super(question, correctAnswer);
		this.wrongChoices = new ArrayList<String>();
		this.in = new Scanner(System.in);
	}
	
	public void addWrongChoices() {		
		System.out.println("Enter wrong choices followed by returns. "
				+ "Enter return when done.");
		//receive erroneous options
		String wrongChoice = in.nextLine();
		//verify there are options to be added
		while (!(wrongChoice = in.nextLine()).isEmpty()){
			this.wrongChoices.add(wrongChoice);
		}
	}
	
	public void displayWrongChoices() {
		int optNum = 1;
		for (String choice : this.wrongChoices) {
			System.out.println(optNum + ". " + choice);
			optNum++;
		}
	}
	
	public void editWrongChoices() {
		displayWrongChoices();

		int index = selectWrongChoice();
		
		System.out.println("Please enter your edits.");
		String editedWrongChoice = in.nextLine();
		
		this.wrongChoices.set(index, editedWrongChoice);
	}
		
	public int selectWrongChoice() {		
		// receive user selection
		int selection = in.nextInt();

		// verify option choice
		while (selection < 1 || selection > (this.wrongChoices.size() + 1)) {
			System.out.println("Invalid selection. Please try again");
			selection = in.nextInt();
		}
		
		// return selection as array's index
		return selection - 1;
	}

	public void removeWrongChoice() {
		displayWrongChoices();

		int index = selectWrongChoice();
		this.wrongChoices.remove(index);
		
		System.out.println("The wrong choice options for this question are now:");
		displayWrongChoices();
	}

	@Override
	public String toString() {
		return "MultipleChoiceQuestion [wrongChoices=" + wrongChoices + ", question=" + question
				+ ", correctAnswer=" + correctAnswer + "]";
	}
	
	
}

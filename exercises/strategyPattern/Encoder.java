package strategyPattern;

import java.util.Scanner;

public class Encoder {
	
//	private Encodable cipherType;
	private Scanner in;
	
	public Encoder(Encodable cipherType) {
		this.in = new Scanner(System.in);
//		this.cipherType = cipherType;
	}

//	getKey()
	
	public String getPlainText() {
		String plainText = in.nextLine();
		return plainText;
	}
	
	public void setEncodable(Encodable cipherType) {
		
	}
	
}

// Once you have finished creating your strategies, create an Encoder class. 
// This class should include functionality for requesting a message from the 
// user as well as a setEncodeable(Encodeable) method that takes in one of your 
// strategies, and an encode method that uses the given strategy to encode the message.
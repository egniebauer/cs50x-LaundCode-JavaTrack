package strategyPattern;


public class CaesarEncode implements Encodable {
	
	private int key;
	
	public CaesarEncode(int key) {
		this.key = key;
	}

	@Override
	public String encode(String plaintext) {
		String plainText = plaintext;
		char plainChar;
		char cipherChar;
		String cipherText = "";
		
		for (int i = 0; i < plainText.length(); i++) {
			plainChar = plainText.charAt(i);
			
			if (Character.isUpperCase(plainChar)) {
				cipherChar = (char) (((((int) plainChar + this.key) - 65) %26) + 65);
				cipherText += cipherChar;
			}
			else if (Character.isLowerCase(plainChar)) {
				cipherChar = (char) (((((int) plainChar + this.key) - 97) %26) + 97);
				cipherText += cipherChar;
			}
			else {
				cipherText += plainChar;
			}
		}
		return cipherText;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	public static void main (String[] args) {
		CaesarEncode newCipher = new CaesarEncode(3);
		String cipherText = newCipher.encode("abc xyz");
		
		System.out.println(cipherText);
	}
}

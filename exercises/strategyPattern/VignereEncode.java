package strategyPattern;

public class VignereEncode implements Encodable {
	
	private String key;
	
	public VignereEncode(String key) {
		this.setKey(key);
	}

	@Override
	public String encode(String plaintext) {
		String plainText = plaintext;
		String cipherText = "";
		char plainChar;
		char keyChar;
		char cipherChar;
		int c = 0;
		int keyshift = 0;
		
		// iterate through each character of the plain text  
		for (int i=0; i < plainText.length(); i++) {
			plainChar = plainText.charAt(i);
			int j = c % (key.length());
			
			keyChar = key.charAt(j);    // cast key to ASCII
			c++;
		    
			if (Character.isUpperCase(keyChar)) {
					keyshift = ((int) keyChar - 65);
			}
			else if (Character.isLowerCase(keyChar)) {
					keyshift = ((int) keyChar - 97);
			}
			else {
					keyshift = 0;
			}
			
			if (Character.isUpperCase(plainChar)) {
				cipherChar = (char) (((((int) plainChar + keyshift) - 65) %26) + 65);
				cipherText += cipherChar;
			}
			else if (Character.isLowerCase(plainChar)) {
				cipherChar = (char) (((((int) plainChar + keyshift) - 97) %26) + 97);
				cipherText += cipherChar;
			}
			else {
				cipherText += plainChar;
			}
		}
		return cipherText;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public static void main (String[] args) {
		VignereEncode newCipher = new VignereEncode("abc");
		String cipherText = newCipher.encode("abc xyz");
		
		System.out.println(cipherText);
	}
}

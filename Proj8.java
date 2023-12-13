/**
 * 
 * This project implements the four-square cipher, allowing for
 * encryption and decryption.
 *
 * <Proj8.java>
 * <Preston Rottinghaus/ 02B Thursday 3:30>
 * <This program is designed to take 2 key and a message from user.
 * using the contoler it will pass the strings between the IO (view file)
 * and the Cipher and Square (modlue).
 * doing this wither enrypts or decrypts the message entered.> 
*/

public class Proj8 {
	/**
	 * Main contoller that passes the variables between the view
	 *  and module to either encrypt or decrypt the users input.
	 * @param args none in this case
	 */
	public static void main(String[] args) {

// Complete the MAIN method
	// Get the KEYS and MESSAGE using IO class
	IO keys = new IO();
	Square entp = new Square();
		String key1 = keys.firstKey();
		if(entp.keycheck(key1)){
			keys.printError(key1);
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<key1.length();i++){
			char ch = key1.charAt(i);
   			 if (ch != ' ') {
        sb.append(ch);
		//System.out.println(ch);
		}
	}
		
		String rtg1 = sb.toString().toUpperCase();
		//System.out.println(rtg1);
		String key2 = keys.secondKey();
		if(entp.keycheck(key2)){
			keys.printError(key2);
			
		}
		StringBuilder sb2 = new StringBuilder();
		for(int i =0;i<key2.length();i++){
			char ch2 = key2.charAt(i);
			if(ch2 != ' '){
				sb2.append(ch2);
				//System.out.println(ch2);
			}
			}
		
		String rtg2 = sb2.toString().toUpperCase();
		key2 = rtg2;
		//System.out.println(key2);
		char action = keys.encryptOrDecrypt();
		boolean encrypt;
		//System.out.println("proj8 " + action);
		if(action == 'd'){
			encrypt = false;
		}
		else{
			encrypt = true;
		}
		String message = keys.message(encrypt);
		
		

	// Pass KEYS to the CIPHER class to ENCRYPT/DECRYPT
	Cipher process = new Cipher(rtg1,key2);
	message = process.despace(message);
		if(entp.entrycheck(message) == false){
			keys.printError(message);
			//entp.errorchek(entp.entrycheck(message));
		}
	if(encrypt == true){
		message = process.encrypt(message);
	}
	else{
		message = process.decrypt(message);
	}
		
	// Use CIPHER class to ENCRYPT/DECRYPT

	// Use IO class to display encrypted or decrypted message
	keys.printResults(message, encrypt);
 } // end main
} // end class
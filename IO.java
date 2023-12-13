/**
 * IO handles all input and output for the
 * four-square encryption algorithm
 *
 * <Proj8.java>
 * <Preston Rottinghaus/ 02B Thursday 3:30>
 * <This program is designed to take 2 key and a message from user.
 * using the contoler it will pass the strings between the IO (view file)
 * and the Cipher and Square (modlue).
 * doing this wither enrypts or decrypts the message entered.> 
 */

import java.util.*;

public class IO {
	private Scanner s;

	/**
	 * IO sets up a new Scanner to System.in
	 */
	public IO() {
		s = new Scanner(System.in);
	}

	/**
	 * firstKey returns the first key from the user
	 *
	 * @return The first key from the user
	 */
	public String firstKey() {
		//COMPLETE THIS TO GET THE FIRST KEY
		System.out.print("enter first key: ");
		String key = s.nextLine();
		//UPDATE THIS LINE WHEN DONE
		return key;
	} // end firstKey


	/**
	 * secondKey returns the second key from the user
	 *
	 * @return The second key from the user
	 */
	public String secondKey() {
		//COMPLETE THIS TO GET THE SECOND KEY
		System.out.print("enter second key: ");
		String key = s.nextLine();
		//UPDATE THIS LINE WHEN DONE
		return key;
	} // end secondKey

	/**
	 * gets and returns whether the user wants to encrypt or decrypt
	 *
	 * @return 'e' for encryption, and 'd' for decryption
	 */
	public char encryptOrDecrypt() {
		//COMPLETE THIS TO GET THE ENCRYPT OR DECRYPT OPTION
		char jump =' ';
		System.out.print("do want to encrypt(e) or decrypt(d): ");
		String move = s.nextLine();
		move = move.toLowerCase();
		//System.out.println("IO file read in " + move);
		if(move.equals( "e")){
			//System.out.print( "Encryption");
			jump = 'e';
		}
		else if(move.equals( "d")){
			//System.out.print( "Decryption");
			jump = 'd';
		}
		//System.out.print(jump);
		//UPDATE THIS LINE WHEN DONE
		return jump;

	} // end encryptOrDecrypt

	/**
	 * message returns the message from the user
	 *
	 * @param encrypt True if encrypting, false if decrypting
	 *
	 * @return The message from the user
	 */
	public String message(boolean encrypt) {
		//COMPLETE THIS TO GET THE MESSAGE
		String message;
		if(encrypt == true){
			System.out.print("Enter message to be encrypted: ");
			message = s.nextLine();
		}
		else{
			System.out.print("Enter message to be decrypted: ");
			message = s.nextLine();
		}
		//UPDATE THIS LINE WHEN DONE
		return message;
	} // end message

	/**
	 * printResults prints the encrypted and decrypted messages
	 *
	 * @param msg The resulting message
	 * @param encrypt True if encrypting, false if decrypting
	 */
	public void printResults(String msg, boolean encrypt) {
		//COMPLETE THIS TO PRINT THE RESULTS
		if(encrypt == true){
			System.out.println("encrypted message is " + msg);
		}
		else{
			System.out.println("decrypted message is " + msg);
		}
	} // end printResults

	/**
	 * printError prints an error message
	 *
	 * @param err The error message to print
	 */
	public void printError(String err) {
		//COMPLETE THIS TO PRINT THE ERROR MESSAGE
		System.out.println("Invaild entry " + err);
		System.exit(0);
	} // end printError

	
} // end class
/**
 * Cipher handles the encryption and decryption of
 * messages according to the four-square cipher algorithm.
 *
 * <Proj8.java>
 * <Preston Rottinghaus/ 02B Thursday 3:30>
 * <This program is designed to take 2 key and a message from user.
 * using the contoler it will pass the strings between the IO (view file)
 * and the Cipher and Square (modlue).
 * doing this wither enrypts or decrypts the message entered.> 
 */
//import java.util.*;
public class Cipher {
	private Square plain1;
	private Square plain2;
	private Square cipher1;
	private Square cipher2;

	
	/**
	 * Cipher creates the four squares based on
	 * two keys for the four-square cipher algorithm.
	 *
	 * @param key1 The first key (no Q's)
	 * @param key2 The second key (no Q's)
	 */
	public Cipher(String key1, String key2) {
		plain1 = new Square();
		plain2 = new Square();
		cipher1 = new Square(key1);
		cipher2 = new Square(key2);
		//COMPLETE THIS CONSTRUCTOR
		//CREATE plain1, plain2, cipher1, and cipher2
	} // end 2 arg constructor

	/**
	 * encrypt returns the encrypted message using the
	 * four-square cipher algorithm
	 *
	 * @param message The message to encrypt
	 *
	 * @return The encrypted message
	 */
	public String encrypt(String message) {
		//COMPLETE THIS METHOD
		//System.out.print(message);
		String ready = message;
		//System.out.print(ready);
		/*
		if(ready.length()%2 !=0){
			System.out.println("Even entries only " + ready);
			System.exit(0);
		}
		*/
		//System.out.print("past if");
		String postcry = " ";
		//String precry = " ";
		String[]ucp = new String[ready.length()/2];
		int a=0;
		for(int i = 2;i<((ready.length()+2));i=i+2){
		 ucp[a]= ready.substring(i-2,i);
		 a++;
		}
		for(int i =0; i< ucp.length; i++){
			char c1 = ucp[i].charAt(0);
			char c2 = ucp[i].charAt(1);
			
			int[] c1pos = plain1.getPos(c1);
				
			int[] c2pos = plain2.getPos(c2);
			char nc1 = cipher1.getChar(c1pos[0],c2pos[1]);
			//System.out.println(c1pos[0] + ", " + c2pos[1]);
			//System.out.println("nc1 = " + nc1);
			char nc2 = cipher2.getChar(c2pos[0],c1pos[1]);
			//System.out.println(c2pos[0] + ", " + c1pos[1]);
			//System.out.println("nc2 = " + nc2);
			postcry = postcry + (char)nc1 + (char)nc2;
			//System.out.println(nc1);
			//System.out.println(nc2);
			//System.out.println(postcry);
		}
		
		//System.out.println();
		//RETURN THE ENCRYPTED message
		postcry += "\n";
		//UPDATE THIS LINE WHEN DONE
		return postcry;
	} // end encrypt

	/**
	 * decrypt returns the decrypted message using the
	 * four-square cipher algorithm
 	 *
	 * @param message The message to decrypt
	 *
	 * @return The decrypted message
	 */
	public String decrypt(String message) {
		//COMPLETE THIS METHOD
		String ready = message;
		/*
		if(ready.length()%2 !=0){
			System.out.println("Even entries only " + ready);
			System.exit(0);
		}
		*/
		String uncry =" ";
		
		String[]ucp = new String[ready.length()/2];
		int a=0;
		for(int i = 2;i<((ready.length()+2));i=i+2){
		 ucp[a]= ready.substring(i-2,i);
		 a++;
		}
		//RETURN THE DECRYPTED message
		for(int i =0; i< ucp.length; i++){
			char c1 = ucp[i].charAt(0);
			char c2 = ucp[i].charAt(1);
			int[] c1pos = cipher1.getPos(c1);
			int[] c2pos = cipher2.getPos(c2);
			char nc1 = plain1.getChar(c1pos[0],c2pos[1]);
			char nc2 = plain2.getChar(c2pos[0],c1pos[1]);
			uncry =  uncry + nc1 + nc2;
			
		}
		//System.out.println();
		//UPDATE THIS LINE WHEN DONE
		uncry += "\n";
		return uncry;
	} // end decrypt
	/**
	 * takes the entered string and removes the spaces
	 * @param message string entered to be despaced
	 * @return string with out spaces
	 */
	public String despace(String message){
		//System.out.println(message);
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<message.length();i++){
			char ch = message.charAt(i);
   			 if (ch != ' ') {
       			 sb.append(ch);
			 }
			 /*
			 if(ch == 'q' || ch == 'Q'){
				System.out.print("Error cannot use Q");
				System.exit(0);
			 }
			 */
		}
		String rtg = sb.toString().toUpperCase();
		//System.out.println(rtg);
		return rtg;
	}
} // end class
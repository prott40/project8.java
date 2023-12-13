/**
 * Square represents one of the squares in the four-square
 * cipher algorithm.
 *
 * <Proj8.java>
 * <Preston Rottinghaus/ 02B Thursday 3:30>
 * <This program is designed to take 2 key and a message from user.
 * using the contoler it will pass the strings between the IO (view file)
 * and the Cipher and Square (modlue).
 * doing this wither enrypts or decrypts the message entered.> 
 */
import java.util.*;
public class Square {
	private char[][] matrix;

	/**
	 * Square constructs a matrix with the letters A-Z, skipping Q.
	 */
	public Square() {
		matrix = new char[5][5];
			matrix[0][0] = 'A';
			matrix[0][1] = 'B';
			matrix[0][2] = 'C';
			matrix[0][3] = 'D';
			matrix[0][4] = 'E';			
			matrix[1][0] = 'F';
			matrix[1][1] = 'G';
			matrix[1][2] = 'H';
			matrix[1][3] = 'I';
			matrix[1][4] = 'J';
			matrix[2][0] = 'K';
			matrix[2][1] = 'L';
			matrix[2][2] = 'M';
			matrix[2][3] = 'N';
			matrix[2][4] = 'O';
			matrix[3][0] = 'P';
			matrix[3][1] = 'R';
			matrix[3][2] = 'S';
			matrix[3][3] = 'T';
			matrix[3][4] = 'U';
			matrix[4][0] = 'V';
			matrix[4][1] = 'W';
			matrix[4][2] = 'X';
			matrix[4][3] = 'Y';
			matrix[4][4] = 'Z';
		//COMPLETE THIS CONSTRUCTOR
		//FILL matrix WITH A-Z, SKIPPING Q
	} // end no-arg constructor

	/**
	 * Square first puts the characters from key into
	 * the matrix, and then fills the matrix with the remaining
	 * letters (skipping Q).
	 *
	 * @param key One of the encryption keys
	 */
	public Square(String key) {
		String nkey = removeDups(key);
		//System.out.println(nkey);
		/* 

		if(strContains(key,'Q')){
			System.out.print("error cannot use Q" + key);
			System.exit(0);
		}
		*/
		//entrycheck(nkey);
		int line = 0;
		int startletter = 65;
		matrix = new char[5][5];
		char [] keyword = new char[nkey.length()];
		for(int i = 0; i < nkey.length(); i++){
			keyword[i] = nkey.charAt(i);
		}
		for(int i = 0; i < 5;i++){
			for(int f = 0; f<5;f++){
				if(line < keyword.length){
					matrix[i][f] = keyword[line];
					line++;
				}
			}
		}
		Arrays.sort(keyword);
		
		int	rio = line/5;
		int cio = (line%5);
		if(cio !=0){
for(int i = cio; i<5;i++){
	for(int l = 0; l < line;l++){
					while( keyword[l]== startletter){
						startletter++;
					}
					while(startletter == 81){
					startletter++;
				}
			}
	matrix[rio][i] = (char)startletter;
	startletter++;

		}
	}
		else{
			for(int i =0; i<5;i++){
				for(int l = 0; l < line;l++){
					while( keyword[l]== startletter){
						startletter++;
					}
					while(startletter == 81){
					startletter++;
				}
			}
	matrix[rio][i] = (char)startletter;
	startletter++;
		}
	}
		for(int j = (rio)+1; j < 5;j++){
			for(int i = 0; i<5;i++){
				for(int l = 0; l < line;l++){
					while( keyword[l]== startletter){
						startletter++;
					}
					while(startletter == 81){
					startletter++;
				}
				}
				
				
				matrix[j][i]=(char)startletter;
				startletter++;
			}
		}
		 /* 
		for (int i = 0; i < 5; i++){
		for (int j = 0; j < 5; j++)
		 System.out.print (matrix[i][j] + " ");
		System.out.println();
		
		} 
		for (int i = 0; i < keyword.length; i++){
			System.out.print(keyword[i]);
		}
		*/
		//COMPLETE THIS CONSTRUCTOR
		//FILL matrix WITH key, THEN REMAINING A-Z, SKIPPING Q
	} // end one-arg constructor

	/**
	 * getChar returns the character at a given
	 * row and column in the matrix.
	 *
	 * @param row The row to look in
	 * @param col The column to look in
	 *
	 * @return The character at (row, col)
	 */
	public char getChar(int row, int col) {
		//COMPLETE THIS METHOD
		//RETURN THE CHARACTER IN MATRIX AT POSITION row,col
		char getit = matrix[row][col];
		//UPDATE THIS LINE WHEN DONE
		return getit;
	} // end getChar

	/**
	 * getPos returns the [row,col] position
	 * of the given character.
	 *
	 * @param c The character to look for
	 *
	 * @return A 1D array holding the row and col of c stored in [0] and [1]
	 */
	public int[] getPos(char c) {
		//COMPLETE THIS METHOD
		//RETURN this array holding the row and col of c stored in [0] and [1], respectively
		int[] pos = new int[2];
		pos[0] = -1;
		pos[1] = -1;
		// Search through matrix for 'c' and, when found
		for(int i =0; i < 5; i++){
			for(int j =0; j<5; j++){
				if(matrix[i][j] == c){
					pos[0] = i;
					pos[1] = j;
				}
				
			}
		}
		// store row in pos[0] and col in pos[1]
		// If NOT found...
		//Leave this code in so that it will compile
		//Assuming char is found so don't need to
		//add code to handle if the char isn't foun
		// character not found
		return pos;	 
	} // end getPos

	/**
	 * strContains returns whether the given string
	 * contains the given character
	 *
	 * @param str The string to search
	 * @param c The character to search for
	 *
	 * @return true if c is in str else false
	 */
	private boolean strContains(String str, char c) {
		for(int i = 0; i< str.length(); i++){
			if((str.charAt(i) == c)){
				return true;
			}
		}
				//COMPLETE THIS METHOD (Optional, but strongly suggested)

		//REMOVE THIS LINE WHEN DONE
		return false;
		
	} // end strContains
	
	/**
	 * removeDups removes all duplicate characters
	 * from the string
	 *
	 * @param key The string to remove duplicates from
	 * 
	 * @return The string with all duplicates removed
	 */
	private String removeDups(String key) {
		//COMPLETE THIS METHOD (Optional, but strongly suggested)
		String nkey = key.toUpperCase();
		StringBuilder sb = new StringBuilder(nkey);

		for (int i = 0; i < nkey.length(); i++) {
   			 char comp = nkey.charAt(i);
    		//System.out.println(comp);
    
    	for (int j = i + 1; j < sb.length(); j++) { // Note the use of sb.length() instead of nkey.length()
       		 //System.out.println(comp + " is or is not equal " + sb.charAt(j));
        	if (comp == sb.charAt(j)) {
            sb.deleteCharAt(j);
            j--; // Decrement j to account for the removed character
        }
    }
}

return sb.toString();

	} // end removeDups	
/**
 * check if a string has odd lengths or has a Q in it, if so retuns false
 * @param entry stirng that needs checke for odd or Q
 * @return false if entry has odd or Q, true if not
 */
	public boolean entrycheck(String entry){
		if(entry.length()%2 != 0 || strContains(entry, 'Q')){
			return false;
		 }
		return true;
	}
/**
 * checks if keys have a Q in them
 * @param check key entered by user
 * @return true if has a Q false if no Q
 */
	public boolean keycheck(String check){
		check = check.toUpperCase();
		if(strContains(check,'Q')){
			return true;
		}
		return false;
	}
} // end class
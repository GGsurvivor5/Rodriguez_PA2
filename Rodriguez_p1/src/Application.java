/*
 * The program will have a public class called Application.
 *    The Application class will have the main method.
 * 	  The main method will take a 4 digit integer from the user.
 *    The main method will call Encrypter.encrypt to encrypt the 4 digit integer.
 *    The main method will print out the encrypted value.
 *    The main method will call Decrypter.decrypt to decrypt the encrypted integer.
 *    The main method will print out the decrypted value.
 *    
 * The program will have a public class called Encrypter.
 *    The Encrypter class will have a method called encrypt. 
 *    The encrypt method will take a 4 digit integer and add 7 to each digit, 
 *    then apply mod 10 to each digit.
 *    The encrypt method will also swap the first digit with the third, and the
 *    second digit with the fourth. 
 * 
 * The program will have a public class called Decrypter.
 *    The Decrypter class will have a method called decrypt.
 *    The decrypt method will operate on the encrypted 4 digit stream, and 
 *    reverse the operations performed by the encrypt method.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

	
	public static void main(String[] args) {
		int plaintext=0;
		int ciphertext=0;
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("Please enter your 4 digit number: ");

		String input=scan.nextLine();
		ArrayList<String> userInput = new ArrayList<String>(Arrays.asList(input.split("")));
		ArrayList<Integer> in = new ArrayList<Integer>();
		for(int i=0; i<userInput.size(); i++) {
			in.add(Integer.parseInt(userInput.get(i)));
		}
		
		ciphertext=Encrypter.encrypt(plaintext);
		System.out.printf("Your encrypted number is: %04d\n", ciphertext);
		
		plaintext=Decrypter.decrypt(ciphertext);			
		System.out.printf("Your decrypted number is: %04d ", plaintext);
					
		
		
		scan.close();
	}

}

/**
 * class XRef - Cross Reference Map
 *
 * I understand the meaning of academic dishonesty, in particular plagiarism, copyright infringement
 * and collusion. I am aware of the consequences if found to be involved in these misconducts. I hereby
 * declare that the work submitted for the "ITP4510 Data Structures & Algorithms" is authentic record
 * of my own work.
 *
 * @Name : Tang Chun Hei
 * @StdID: 200022972
 * @Class: IT114105/1D
 * @2021-02-19
 */
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class XRef {
	public static final String[] reservedWords = {"abstract", "assert", "boolean", "break", "byte", 
			"case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", 
			"enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", 
			"import", "instanceof", "int", "interface", "long", "native", "new", "package", 
			"private", "protected", "public", "return", "short", "static", "strictfp", "super", 
			"switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", 
			"volatile", "while"};
		
	private static final String
		DELIMITER = "\"(?:\\\\\"|[^\"])*?\"|[\\s.,;:+*/|!=><@?#%&(){}\\-\\^\\[\\]\\&&]+";
		
	public static String[] tokenizer(String javaStmt) {
		String[] tokens = javaStmt.split(DELIMITER);
		return tokens;
	}

	public static void main(String [] args) throws FileNotFoundException {
		if (args.length < 1) { // remind to input file.
			System.out.println("Please input your file!");
			return;
		}
		String filename = args[0];
		File file = new File(filename);
		if (!file.exists()) { // remind to check the file name.
			System.out.println("Please input your file name correctly!");
			return;
		}
		Scanner fin = new Scanner(file);
		int cnt = 1; // set the line number to 0001.
		// print the heading.
		System.out.println("X R e f  v 1\n============================================\n" +
				"Program created by TANG Chun Hei. 01-04-2021\n\nSOURCE FILE: " + filename);

		IdenList idenList = new IdenList(new IdenComparator()); // create a new linked list for each identifier.
		while (fin.hasNextLine()) {
			String line = fin.nextLine();
			System.out.printf("%04d | %s\n", cnt, line);
			String[] tokens = tokenizer(line);
			for (String token : tokens) {
				if (isIden(token)) { // search identifier.
					idenList.insertInOrder(new Identifier(token), cnt); // save the line number to the sup-linked list.
				}
			}
			cnt++;
		}
		System.out.println("\nCROSS REFERENCE: ");
		while (!idenList.isEmpty()) { // print sup-linked list.
			Identifier iden = (Identifier)idenList.removeFromHead();
			System.out.printf("%-20s\t: [ ", iden.iden);
			while (!iden.list.isEmpty()) {
				System.out.print(iden.list.removeFromHead() + " ");
			}
			System.out.println("]");
		}
	}
	
	public static boolean isIden(String token) { // check token is reserved words or not and start with letter, _, $.
		return token.length() > 0 && !checkWord(token) && 
				(Character.isLetter(token.charAt(0)) || token.charAt(0) == '_' || token.charAt(0) == '$');
	}
	
	public static boolean checkWord (String token) { // used binary search to compare the token with reserved words.
		int lower = 0;
		int upper = reservedWords.length - 1;
		while ( lower <= upper) {
			int mid = lower + (upper - lower) / 2;
			int compare = token.compareTo(reservedWords[mid]); // compare the token with the midpoint of the reserved words.
			if (compare > 0) { // if the token greater than the midpoint of the reserved words, reset the lower point to midpoint.
				lower = mid + 1;
			}else if (compare < 0) { // if the token smaller than the midpoint of the reserved words, reset the upper point to midpoint.
				upper = mid - 1;
			}else {
				return true;
			}
		}
		return false;
	}
}
package fileWriting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWriter {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File theFile = new File("H:/HelloWorld.txt");
		Scanner input = new Scanner(theFile);
		while(input.hasNextLine()){
			System.out.println(input.nextLine());
		}
	}
}

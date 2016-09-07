package fileWriting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		Scanner input;
		try{
			File theFile = new File("H:/HelloWorld.txt");
			input = new Scanner(theFile);
		}catch(Exception e){
			System.out.println("File could not be found");
			input = new Scanner(System.in);
		}
		
		while(input.hasNextLine()){
			System.out.println(input.nextLine());
		}
	}
}

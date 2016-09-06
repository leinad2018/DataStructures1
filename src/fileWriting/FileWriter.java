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
	public static void main(String[] args){
		File theFile;
		try{
			theFile = new File("H:/HelloWorld.txt");
		}catch(Exception e){
			System.out.println("File could not be found");
			theFile = new File();
		}
		Scanner input = new Scanner(theFile);
		while(input.hasNextLine()){
			System.out.println(input.nextLine());
		}
	}
}

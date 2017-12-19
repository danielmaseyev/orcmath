package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Input {

	public Input()
	{	
	
	}
	public static void main(String[] args) {
		Scanner text = new Scanner(System.in);
		System.out.println("Please enter something");
		String name = text.nextLine();	

		SaveContent("test.csv");
	}
	private static void SaveContent(String fileName) {

		try{    

			FileWriter fw=new FileWriter(text.txt);    
			
			fw.write(fileName);    
			fw.close();    

			System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){

			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}
		
	}
}

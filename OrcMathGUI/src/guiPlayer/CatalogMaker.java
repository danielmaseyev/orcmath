package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {
	private ArrayList<Movies> list; 
	
	public CatalogMaker() {
		list = new ArrayList<Movies> ();
		list.add(new Movies("Star Wars", "Action"));
		list.add(new Movies("Forrest Gump", "Comedy"));
		list.add(new Movies("Borat", "Comedy"));
		list.add(new Movies("Avengers", "Action"));
		list.add(new Movies("Titanic", "Drama"));
	}
	public String getCsvContent()
	{
		String data = "name, genre \n";
		for(Movies m : list)
		{
			data += m+"\n";
		}
		return data;
	}
	public void addNewItem(String name, String genre)
	{
		list.add(new Movies(name,genre));	
		System.out.println("Movie added);
	}

	public static void main(String[] args) {
		CatalogMaker x = new CatalogMaker();
		System.out.println(x.getCsvContent());
		Scanner input = new Scanner(System.in);
		while(input.nextLine() != "stop");
		System.out.println("Please enter a movie");
		String name = input.nextLine();	
		System.out.println("Now add a genre");
		String genre  = input.nextLine();
	}

}

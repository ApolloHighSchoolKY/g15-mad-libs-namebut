// A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("run");
		nouns.add("Jonathan Leohr");
		adjectives.add("purple");
		story = "Jonathan Leohr run down the purple road.";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadAdjectives();
		loadNouns();
		loadVerbs();
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner chopper = new Scanner(new File(fileName));
			

			//While there is more of the story, read in the word/symbol
			while (chopper.hasNext())
			{
				String currentWord = chopper.next();
			
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				if(currentWord.equals("#"))
				{
					currentWord = getRandomNoun();
				}
				else if(currentWord.equals("@"))
				{
					currentWord = getRandomVerb();
				}
				else if(currentWord.equals("&"))
				{
					currentWord = getRandomAdjective();
				}
				story += currentWord + " ";
			}
			chopper.close();
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));
			while (reader.hasNext())
			{
				nouns.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));
			while (reader.hasNext())
			{
				verbs.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));
			while (reader.hasNext())
			{
				adjectives.add(reader.nextLine());
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		Random rand = new Random();
		int randVerb = rand.nextInt(verbs.size());
		return verbs.get(randVerb);
	}

	public String getRandomNoun()
	{
		Random rand = new Random();
		int randNoun = rand.nextInt(nouns.size());
		return nouns.get(randNoun);
	}

	public String getRandomAdjective()
	{
		Random rand = new Random();
		int randAdj = rand.nextInt(adjectives.size());
		return adjectives.get(randAdj);
	}

	public String toString()
	{
		return story + "";
	}
}
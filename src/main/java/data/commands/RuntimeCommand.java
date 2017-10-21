package data.commands;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

import data.arguments.RuntimeArgumentList;

import java.util.ArrayList;

public class RuntimeCommand
{
	
	//--------------------------------------------------
	//----- _ ------------------------------------------
	//--------------------------------------------------
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	//--------------------------------------------------
	//----- Constants ----------------------------------
	//--------------------------------------------------
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	//--------------------------------------------------
	//----- Variables ----------------------------------
	//--------------------------------------------------
	private final String name;
	private RuntimeArgumentList arguments;
	private ArrayList<String> directories;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public RuntimeCommand(final String name, final RuntimeArgumentList arguments, final ArrayList<String> directories)
	{
		this.name = name;
		this.arguments = arguments;
		this.directories = directories;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isAtFinalDirectory()
	{
		return directories.isEmpty();
	}
	
	public String moveUpDirectory()
	{
		String dir = directories.get(0);
		directories.remove(0);
		return dir;
	}
	
	public static RuntimeCommand parseCommandFromString(final String input)
	{
		String[] separated = splitInputIntoParts(input);
		ArrayList<String> directories = splitIntoDirectories(separated[0]);
		
		
		return null;
	}
	
	private void checkStringForInvalidSyntax(final String input)
	{
	
	}
	
	private static String[] splitInputIntoParts(String input)
	{
		throw new UnsupportedOperationException();
	}
	
	private static ArrayList<String> splitIntoDirectories(String input)
	{
		throw new UnsupportedOperationException();
	}
	
	private RuntimeArgumentList splitIntoArguments(String input)
	{
		throw new UnsupportedOperationException();
	}
	
}

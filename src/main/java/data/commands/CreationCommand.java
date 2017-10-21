package data.commands;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------
import java.util.ArrayList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public abstract class CreationCommand extends Command
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
	private ArrayList<String> directories;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public CreationCommand(final String name, final ArrayList<String> directories)
	{
		this.name = name;
		this.directories = directories;
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
	
}

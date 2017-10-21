package data.commands;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------
import data.CommandDirectory;
import data.arguments.ArgumentList;
import data.arguments.RuntimeArgumentList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public abstract class Command
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
	protected String name;
	protected ArgumentList arguments;
	
	private RuntimeArgumentList runtimeArgs;
	private CommandDirectory directory;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	protected Command()
	{
		
	}
	
	public void execute(RuntimeArgumentList args)
	{
		runtimeArgs = args;
		onExecute();
	}
	
	public abstract void onExecute();
	
	private boolean argPassed(final char label)
	{
		return runtimeArgs.argPassed(label);
	}
	
	public String getName()
	{
		return name;
	}
	
	private CommandDirectory getDirectory()
	{
		return directory;
	}
	public <T> void setDirectory(CommandDirectory directory)
	{
		this.directory = directory;
	}
	
}

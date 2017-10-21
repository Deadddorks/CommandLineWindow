package graphics;//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

import importable.javafx.ConsolePane;

public class WindowData
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
	final ConsolePane data;
	final ConsolePane console;
	final ConsolePane output;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public WindowData(final ConsolePane data, final ConsolePane console, final ConsolePane output)
	{
		this.data = data;
		this.console = console;
		this.output = output;
	}
	
	public ConsolePane getData()
	{
		return data;
	}
	public ConsolePane getConsole()
	{
		return console;
	}
	public ConsolePane getOutput()
	{
		return output;
	}
}

package data.arguments;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------
import exceptions.ArgumentNotFoundException;

import java.util.ArrayList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public class RuntimeArgumentList
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
	ArrayList<RuntimeArgument> arguments;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public RuntimeArgumentList()
	{
		arguments = new ArrayList<>();
	}
	
	public void addArgument(final RuntimeArgument argument)
	{
		arguments.add(argument);
	}
	
	public RuntimeArgument[] getArgList()
	{
		RuntimeArgument[] args = new RuntimeArgument[arguments.size()];
		
		for (int i = 0; i < arguments.size(); i++)
		{
			args[i] = arguments.get(i);
		}
		
		return args;
	}
	
	public RuntimeArgument getArgByLabel(final char label) throws ArgumentNotFoundException
	{
		for (RuntimeArgument arg : arguments)
		{
			if (arg.labelMatch(label))
			{
				return arg;
			}
		}
		throw new ArgumentNotFoundException(label);
	}
	
	public boolean argPassed(char label)
	{
		for (RuntimeArgument arg : arguments)
		{
			if (arg.labelMatch(label))
			{
				return true;
			}
		}
		return false;
	}
	
}

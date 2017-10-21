package data.arguments;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------
import exceptions.ArgumentNotFoundException;

import java.util.ArrayList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public class ArgumentList
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
	private ArrayList<Argument> arguments;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public ArgumentList()
	{
		arguments = new ArrayList<>();
	}
	
	public void addArgument(final Argument argument)
	{
		arguments.add(argument);
	}
	
	public Argument[] getArgList()
	{
		Argument[] args = new Argument[arguments.size()];
		
		for (int i = 0; i < arguments.size(); i++)
		{
			args[i] = arguments.get(i);
		}
		
		return args;
	}
	
	public Argument getArgByLabel(final char label) throws ArgumentNotFoundException
	{
		for (Argument arg : arguments)
		{
			if (arg.labelMatch(label))
			{
				return arg;
			}
		}
		throw new ArgumentNotFoundException(label);
	}
	
}

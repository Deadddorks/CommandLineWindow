package data;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

import exceptions.InvalidArgLabelException;

public class Argument
{
	
	//--------------------------------------------------
	//----- _ ------------------------------------------
	//--------------------------------------------------
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	//--------------------------------------------------
	//----- Constants ----------------------------------
	//--------------------------------------------------
	public enum ExpectedArgType	{INTEGER, DOUBLE, STRING}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	//--------------------------------------------------
	//----- Variables ----------------------------------
	//--------------------------------------------------
	protected char argLabel;
	
	protected String description;
	protected ExpectedArgType expectedArgType;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	protected Argument(final char argLabel, final String description, final ExpectedArgType expectedArgType)
	{
		if (!Character.isAlphabetic(argLabel))
		{
			throw new InvalidArgLabelException(argLabel);
		}
		
		this.argLabel = argLabel;
		this.description = description;
		this.expectedArgType = expectedArgType;
	}
	
	public char getArgLabel()
	{
		return argLabel;
	}
	public String getDescription()
	{
		return description;
	}
	public ExpectedArgType getExpectedArgType()
	{
		return expectedArgType;
	}
	
	@Override
	public String toString()
	{
		return "-" + Character.toString(argLabel) + " ("+expectedArgType+") " + description;
	}
}

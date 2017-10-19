package data;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

import com.sun.javaws.exceptions.InvalidArgumentException;
import exceptions.ParameterParseFailureException;

import java.security.InvalidParameterException;

public class RuntimeArgument
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
	final char argLabel;
	final String arg;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public RuntimeArgument(final char argLabel, final String arg)
	{
		this.argLabel = argLabel;
		this.arg = arg;
	}
	
	public char getArgLabel()
	{
		return argLabel;
	}
	
	public String getArgAsString()
	{
		return arg;
	}
	public int getArgAsInt() throws ParameterParseFailureException
	{
		try
		{
			return Integer.parseInt(arg);
		}
		catch (NumberFormatException e)
		{
			throw new ParameterParseFailureException(arg, Argument.ExpectedArgType.INTEGER);
		}
	}
	public double getArgAsDouble() throws ParameterParseFailureException
	{
		try
		{
			return Double.parseDouble(arg);
		}
		catch (NumberFormatException e)
		{
			throw new ParameterParseFailureException(arg, Argument.ExpectedArgType.DOUBLE);
		}
	}
	
}

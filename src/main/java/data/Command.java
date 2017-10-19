package data;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

import exceptions.ParameterNotFoundException;
import exceptions.ParameterParseFailureException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

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
	protected ArrayList<Argument> arguments;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	protected Command(final String name)
	{
		this.name = name;
	}
	
	public abstract void onRun(final RuntimeArgument... args) throws ParameterParseFailureException, ParameterNotFoundException;
	
	public void run(final RuntimeArgument... args)
	{
		try
		{
			onRun(args);
		}
		catch (ParameterParseFailureException parseFail)
		{
		
		}
		catch (ParameterNotFoundException notFound)
		{
		
		}
	}
	
	public String getName()
	{
		return name;
	}
	public Argument[] getArgs()
	{
		Argument[] args = new Argument[arguments.size()];
		
		for (int i = 0; i < arguments.size(); i++)
		{
			args[i] = arguments.get(i);
		}
		
		return args;
	}
	
	protected int getIntFromParameter(final char param, final RuntimeArgument... args) throws ParameterNotFoundException, ParameterParseFailureException
	{
		for (RuntimeArgument arg : args)
		{
			if (arg.getArgLabel() == param)
			{
				return arg.getArgAsInt();
			}
		}
		throw new ParameterNotFoundException(param);
	}
	protected double getDoubleFromParameter(final char param, final RuntimeArgument... args) throws ParameterNotFoundException, ParameterParseFailureException
	{
		for (RuntimeArgument arg : args)
		{
			if (arg.getArgLabel() == param)
			{
				return arg.getArgAsDouble();
			}
		}
		throw new ParameterNotFoundException(param);
	}
	protected String getStringFromParameter(final char param, final RuntimeArgument... args) throws ParameterNotFoundException
	{
		for (RuntimeArgument arg : args)
		{
			if (arg.getArgLabel() == param)
			{
				return arg.getArgAsString();
			}
		}
		throw new ParameterNotFoundException(param);
	}
	
	@Override
	public String toString()
	{
		String out = name + " ";
		
		for (int i = 0; i < arguments.size(); i++)
		{
			out += arguments.get(i).toString();
			if (i + 1 < arguments.size())
			{
				out += " ";
			}
		}
		
		return out;
	}
	
}

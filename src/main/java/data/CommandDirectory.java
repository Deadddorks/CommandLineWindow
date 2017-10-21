package data;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

import data.commands.Command;
import data.commands.CreationCommand;
import data.commands.RuntimeCommand;
import exceptions.CommandDoesNotExistException;
import graphics.WindowData;

import java.util.ArrayList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public class CommandDirectory
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
	private String name;
	private String path;
	
	private ArrayList<Command> commands;
	private ArrayList<CommandDirectory> directories;
	
	private WindowData windows;
	private Object superClass;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public CommandDirectory(final Object superClass, final WindowData windows)
	{
		init(superClass, windows, "", "");
	}
	
	public CommandDirectory(final Object superClass, final WindowData windows, final String name, final String path)
	{
		init(superClass, windows, name, path);
	}
	
	private void init(final Object superClass, final WindowData windows, final String name, final String path)
	{
		this.superClass = superClass;
		this.windows = windows;
		this.name = name;
		this.path = path;
		
		commands = new ArrayList<>();
		directories = new ArrayList<>();
		
		commands.add(new CreationCommand("help", new ArrayList<>())
		{
			@Override
			public void onExecute()
			{
				windows.getConsole().print(" - Directories - ");
				for (CommandDirectory d : directories)
				{
					windows.getConsole().print(d.getName());
				}
				windows.getConsole().print(" - Commands - ");
				for (Command c : commands)
				{
					windows.getConsole().print(c.getName());
				}
			}
		});
		commands.add(new CreationCommand("test", new ArrayList<>())
		{
			@Override
			public void onExecute()
			{
				System.out.println("superClass(CommandDirectory): " + superClass);
				windows.getOutput().print(superClass.toString());
			}
		});
	}
	
	public Object getSuperClass()
	{
		return superClass;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPath()
	{
		return path;
	}
	
	private boolean hasCommand(final String commandName)
	{
		for (Command c : commands)
		{
			if (c.getName().equalsIgnoreCase(commandName))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean hasDirectory(final String directoryName)
	{
		for (CommandDirectory d : directories)
		{
			if (d.getName().equalsIgnoreCase(directoryName))
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean nameExists(final String name)
	{
		return !(hasCommand(name) && hasDirectory(name));
	}
	
	public void addCommand(CreationCommand command)
	{
		if (command.isAtFinalDirectory()) // At the command level
		{
			command.setDirectory(this);
			if (nameExists(command.getName()))
			{
				// Throw already exists exception
			}
			else // Need to go deeper into directories
			{
				commands.add(command);
			}
		}
		else
		{
			String dir = command.moveUpDirectory();
			if (!hasDirectory(dir))
			{
				createDirectory(dir);
			}
			getDirectoryByName(dir).addCommand(command);
		}
	}
	
	public Command getCommandByName(final String name)
	{
		for (Command c : commands)
		{
			if (c.getName().equalsIgnoreCase(name))
			{
				return c;
			}
		}
		return null;
	}
	public CommandDirectory getDirectoryByName(final String name)
	{
		for (CommandDirectory d : directories)
		{
			if (d.getName().equalsIgnoreCase(name))
			{
				return d;
			}
		}
		return null;
	}
	
	private void createDirectory(final String name)
	{
		directories.add(new CommandDirectory(superClass, windows, name, path + "/" + name));
	}
	
	public void execute(RuntimeCommand command) throws CommandDoesNotExistException
	{
		if (command.isAtFinalDirectory())
		{
			if (hasCommand(command.getName()))
			{
				getCommandByName(command.getName()).execute(null);
			}
			else
			{
				throw new CommandDoesNotExistException(path, command.getName());
			}
		}
	}
	
}

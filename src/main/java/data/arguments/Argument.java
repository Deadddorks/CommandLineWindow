package data.arguments;
//--------------------------------------------------
//----- Imports ------------------------------------
//--------------------------------------------------

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

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
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	//--------------------------------------------------
	//----- Variables ----------------------------------
	//--------------------------------------------------
	private char label;
	private String name;
	private String description;
	private ReturnType type;
	private boolean required;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	public Argument(final char label, final String name, final String description)
	{
		init(label, name, description, ReturnType.NULL, false);
	}
	
	public Argument(final char label, final String name, final String description, final ReturnType type)
	{
		init(label, name, description, type, false);
	}
	
	public Argument(final char label, final String name, final String description, final boolean required)
	{
		init(label, name, description, ReturnType.NULL, required);
	}
	
	public Argument(final char label, final String name, final String description, final ReturnType type, final boolean required)
	{
		init(label, name, description, type, required);
	}
	
	
	private void init(final char label, final String name, final String description, final ReturnType type, final boolean required)
	{
		this.label = label;
		this.name = name;
		this.description = description;
		this.type = type;
		this.required = required;
	}
	
	public boolean labelMatch(final char labelToTest)
	{
		return (label == labelToTest);
	}
	
	public char getLabel()
	{
		return label;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public ReturnType getType()
	{
		return type;
	}
	
	public boolean isRequired()
	{
		return required;
	}
}

package graphics;

// Imports

public class MainClass
{
	
	public MainClass()
	{
		Test_2 test = new Test_2();
		//Window window = new Window();
		Window window = new Window(test);
		javafx.application.Application.launch(window.getClass());
	}
	
	public static void main(String[] args)
	{
		MainClass mainClass = new MainClass();
	}
	
	public class Test_2
	{
		@Override
		public String toString()
		{
			return "I am a test class!";
		}
	}
	
}

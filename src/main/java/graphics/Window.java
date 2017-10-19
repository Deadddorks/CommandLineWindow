package graphics;
//----- Imports ------------------------------------
//--------------------------------------------------
import importable.javafx.ConsolePane;
import importable.javafx.GridHandler;
import importable.javafx.NodeGenerator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~

public class Window extends Application
{
	
	//--------------------------------------------------
	//----- _ ------------------------------------------
	//--------------------------------------------------
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	//--------------------------------------------------
	//----- Constants ----------------------------------
	//--------------------------------------------------
	private enum ConsoleWindow {DATA, CONSOLE, OUTPUT}
	
	private final int WIDTH = 1200;
	private final int HEIGHT = 900;
	
	private final String fontName = "Ariel";
	private final int fontSize = 15;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	//--------------------------------------------------
	//----- Variables ----------------------------------
	//--------------------------------------------------
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	private NodeGenerator nodeGenerator = new NodeGenerator(new Font("Times New Roman", 15), Color.BLACK);
	
	private Scene scene;
	private GridHandler grid;
	private ConsolePane topScrollPane1, topScrollPane2, bottomScrollPane;
	private TextField textField;
	
	private int prevIndex;
	private ArrayList<String> prevCommands;
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~
	
	@Override
	public void start(Stage window) throws Exception
	{
		
		nodeGenerator.addFont(new Font("Ariel", 25));
		prevCommands = new ArrayList<>();
		prevCommands.add("");
		prevIndex = 0;
		
		// Init Grid
		grid = new GridHandler();
		grid.addColumn(WIDTH / 2, 0);
		grid.addColumn(-1, 0);
		grid.addRow(200, 0);
		grid.addRow(-1, 0);
		grid.addRow(-2, 0);
		grid.initGridPaneConstraints();
		
		// Init Scrolls
		topScrollPane1 = new ConsolePane(fontName, fontSize);
		topScrollPane1.setFormat(5, 5);
		topScrollPane1.setPadding(new Insets(5));
		topScrollPane2 = new ConsolePane(fontName, fontSize);
		topScrollPane2.setPadding(new Insets(5));
		bottomScrollPane = new ConsolePane(fontName, fontSize);
		bottomScrollPane.setPadding(new Insets(5));
		
		// Add contents to boxes
		int j = 25;
		for (int i = 0; i < j; i++)
		{
			topScrollPane1.add(nodeGenerator.createCheckBox("["+(i+1)+"]"), true);
		}
		
		// Text editor
		textField = nodeGenerator.createTextField("Enter commands here", 1);
		textField.setOnKeyPressed(e -> {
			switch (e.getCode())
			{
				case ENTER:
					if (textField.getText().length() > 0)
					{
						String cmd = textField.getText();
						runCommand(cmd);
						prevCommands.add(1, cmd);
						textField.setText("");
					}
					break;
				case UP:
					pullPrev(1);
					break;
				case DOWN:
					pullPrev(-1);
					break;
			}
		});
		
		// Add to grid
		grid.add(topScrollPane1, 0, 0);
		grid.add(topScrollPane2, 1, 0);
		grid.add(bottomScrollPane, 0, 1, 2, 1);
		grid.add(textField, 0, 2, 2, 1);
		
		// Set up window
		scene = new Scene(grid, WIDTH, HEIGHT);
		window.setScene(scene);
		window.setTitle("Neural Network GUI");
		window.sizeToScene();
		window.show();
		
		// After Setup
		textField.requestFocus();
	}
	
	private void pullPrev(final int delta)
	{
		if (prevCommands.size() == 0)
		{
			return;
		}
		if (prevIndex + delta < 0 || prevIndex + delta >= prevCommands.size())
		{
			return;
		}
		prevIndex += delta;
		textField.setText(prevCommands.get(prevIndex));
	}
	
	private void runCommand(final String command)
	{
		topScrollPane2.print("["+command+"]");
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
}

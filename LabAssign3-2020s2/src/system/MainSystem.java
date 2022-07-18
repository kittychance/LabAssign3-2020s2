package system;

import domain.BookFlightFrame;
import domain.CreateFlightFrame;
import domain.FlightsDatabase;
import domain.MainMenuFrame;
import domain.RetrieveFlightFrame;

public class MainSystem {
	public static void main(String[] args)
	{
		MainSystem system = new MainSystem();
		system.setup();
		system.showMainMenuGUI();
	}
	
	public static FlightsDatabase database;
	
	/**
	 * Sets up the system database ready for manipulation.
	 */
	public void setup()
	{
		database = new FlightsDatabase();
	}
	
	/**
	 * Causes the GUI of the main menu to be displayed. 
	 */
	public void showMainMenuGUI()
	{
		// Students to insert code here which will cause the GUI containing the main menu, to be displayed
		new MainMenuFrame();  //pop up the main menu
		
		//Test
		//new CreateFlightFrame();
		//new BookFlightFrame();
		//new RetrieveFlightFrame();
	}
}

package tp1.control;

import java.util.Scanner;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.view.GameView;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		view.showWelcome();
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		Scanner entrada = new Scanner (System.in);
		String command;
		
		do {
			view.showGame();
			command = entrada.nextLine();
			command.toLowerCase();
			
			
			
		}while(command != "e" || command != "exit");
		
		entrada.close();
		view.showEndMessage();
	}
	
	public void draw() {
		view.showGame();
	}

}

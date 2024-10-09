package tp1.control;

import java.util.Scanner;

import tp1.logic.Game;
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
		String command = "";
		
		do {
			//APAÑO PARA QUE NO SE REPINTE EL TABLERO EN HELP O EN COMANDO ERRONEO
			//(PENSAR OTRA FORMA) 
			if(command.equals("")||command.equals("none") || command.equals("n")
					|| command.equals("reset") || command.equals("r")) {
				view.showGame();
			}
			
			System.out.print("Command > ");
			command = entrada.nextLine();
			command.toLowerCase();
			
			if(command.equals("r") || command.equals("reset")) {
				
			}
			else if(command.equals("h") || command.equals("help")) {
				System.out.println(game.help()); 
			}
			else if(command.equals("") || command.equals("none") || command.equals("n")) {
				game.update();
			}
			else if(!(command.equals("e")) && !(command.equals("exit"))) System.out.println("-- The command entered is incorrect--");
			
		}while(!(command.equals("e")) && !(command.equals("exit")) && !game.gameEnds());
		
		view.showGame();
		entrada.close();
		view.showEndMessage();
	}

}

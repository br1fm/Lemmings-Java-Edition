package tp1.control;

import java.util.Arrays;
import java.util.Scanner;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

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
			if(command.equals("")||command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)
					|| command.equals("reset") || command.equals("r")) {
				view.showGame();
			}
			
			//String prompt = Messages.PROMPT;
			System.out.print(Messages.PROMPT);
			command = entrada.nextLine();
			command.toLowerCase();
			
			if(command.equals("r") || command.equals("reset")) {
				
			}
			else if(command.equals(Messages.COMMAND_HELP_NAME) || command.equals(Messages.COMMAND_HELP_SHORTCUT)) {
				String str[] = Messages.HELP_LINES;
				System.out.println(Arrays.toString(str)); 
			}
			else if(command.equals("") || command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)) {
				game.update();
			}
			else if(!(command.equals(Messages.COMMAND_EXIT_NAME)) && !(command.equals(Messages.COMMAND_EXIT_SHORTCUT))) {
				
				System.out.println(Messages.INVALID_COMMAND);
				
			}
			
		}while(!(command.equals(Messages.COMMAND_EXIT_SHORTCUT)) && !(command.equals(Messages.COMMAND_EXIT_NAME)) && !game.gameEnds());
		
		view.showGame();
		entrada.close();
		view.showEndMessage();
	}

}


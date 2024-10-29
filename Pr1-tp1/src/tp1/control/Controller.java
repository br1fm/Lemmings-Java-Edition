package tp1.control;

import java.util.Arrays;
import java.util.Scanner;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class Controller {

	private Game game;
	private GameView view;

	/**
	 * Constructor de la clase Controller.
	 * Inicializa el juego (game) y la vista (view).
	 * 
	 * @param game El objeto de la clase Game que gestiona la lógica del juego.
	 * @param view El objeto de la clase GameView que gestiona la visualización del juego.
	 */
	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}

	/**
	 * Método principal que ejecuta el bucle de control del juego.
	 * Gestiona los comandos introducidos por el usuario, actualiza
	 * el estado del juego y muestra el estado final del juego cuando se termina.
	 */
	public void run() {
		view.showWelcome();
		Scanner entrada = new Scanner (System.in);
		String command = "";
		
		do {
			if(command.equals("")||command.equalsIgnoreCase(Messages.COMMAND_NONE_NAME) || command.equalsIgnoreCase(Messages.COMMAND_NONE_SHORTCUT)
					|| command.equalsIgnoreCase("reset") || command.equalsIgnoreCase("r")) {
				view.showGame();
			}	
			
			String[] prompt = view.getPrompt();
			command = prompt[0];
			
			if(command.equalsIgnoreCase("r") || command.equalsIgnoreCase("reset")) {
				game.reset();
			}
			else if(command.equalsIgnoreCase(Messages.COMMAND_HELP_NAME) || command.equalsIgnoreCase(Messages.COMMAND_HELP_SHORTCUT)) {
				String str[] = Messages.HELP_LINES;
				view.showMessage(Arrays.toString(str));
			}
			else if(command.equals("") || command.equalsIgnoreCase(Messages.COMMAND_NONE_NAME) || command.equalsIgnoreCase(Messages.COMMAND_NONE_SHORTCUT)) {
				game.update();
			}
			else if(!(command.equalsIgnoreCase(Messages.COMMAND_EXIT_NAME)) && !(command.equalsIgnoreCase(Messages.COMMAND_EXIT_SHORTCUT))) {
				
				view.showError(Messages.INVALID_COMMAND);
				
			}
			
		}while(!(command.equalsIgnoreCase(Messages.COMMAND_EXIT_SHORTCUT)) && !(command.equalsIgnoreCase(Messages.COMMAND_EXIT_NAME)) && !game.gameEnds());
		
		view.showGame();
		entrada.close();
		view.showEndMessage();
	}

}


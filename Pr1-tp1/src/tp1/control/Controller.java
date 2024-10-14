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
			if(command.equals("")||command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)
					|| command.equals("reset") || command.equals("r")) {
				view.showGame();
			}
			
			System.out.print(Messages.PROMPT);
			command = entrada.nextLine();
			command.toLowerCase();
			
			if(command.equals("r") || command.equals("reset")) {
				game.reset();
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


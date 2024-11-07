package tp1.control;

import tp1.view.GameView;
import tp1.view.Messages;
import tp1.control.command.Command;
import tp1.control.command.CommandGenerator;
import tp1.logic.GameModel;

public class Controller {

	private GameModel game;
	private GameView view;

	/**
	 * Constructor de la clase Controller.
	 * Inicializa el juego (game) y la vista (view).
	 * 
	 * @param game El objeto de la clase Game que gestiona la lógica del juego.
	 * @param view El objeto de la clase GameView que gestiona la visualización del juego.
	 */
	public Controller(GameModel game, GameView view) {
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
		view.showGame();
		
		while (!game.isFinished()) {

		    String[] userWords = view.getPrompt();
		    Command command = CommandGenerator.parse(userWords);

		    if (command != null) 
				command.execute(game, view);
		    else 
		        view.showError(Messages.UNKNOWN_COMMAND.formatted(userWords[0]));
		} 
		
		view.showEndMessage();
	}

}


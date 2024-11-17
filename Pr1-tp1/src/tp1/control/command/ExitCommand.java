package tp1.control.command;
import tp1.logic.GameModel;

import tp1.view.GameView;
import tp1.view.Messages;

/**
 * Clase que representa el comando de salida del juego.
 * Este comando permite terminar la ejecución del juego cuando el jugador lo solicite.
 * 
 * <p>Esta clase extiende {@link NoParamsCommand} y se encarga de gestionar la salida
 * del juego cuando se ejecuta el comando correspondiente.</p>
 */

public class ExitCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;
	
    /**
     * Constructor que inicializa el comando con su nombre, atajo, detalles y ayuda.
     */
	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    /**
     * Ejecuta el comando de salida, mostrando la vista del juego y cerrando el juego.
     *
     * @param game El modelo del juego, utilizado para realizar la acción de salida.
     * @param gameview La vista del juego, utilizada para mostrar la interfaz antes de salir.
     */
	public void execute(GameModel game, GameView gameview) {
		gameview.showGame();
		game.gameExit();
	}
	
}

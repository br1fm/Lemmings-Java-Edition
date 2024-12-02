package tp1.control.command;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 * Clase que representa el comando para reiniciar el juego.
 * Este comando permite al jugador iniciar una nueva partida.
 * 
 * <p>Esta clase extiende {@link NoParamsCommand} y se encarga de ejecutar la lógica
 * de reinicio del juego cuando el jugador invoca el comando correspondiente.</p>
 */

public class ResetCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_RESET_NAME;
	private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
	private static final String HELP = Messages.COMMAND_RESET_HELP;
	
	 /**
     * Constructor que inicializa el comando con su nombre, atajo, detalles y ayuda.
     */
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    /**
     * Ejecuta el comando de reinicio, restableciendo el juego a su estado inicial.
     *
     * @param game El modelo del juego, que gestiona el estado del juego.
     * @param gameview La vista del juego, que se utiliza para mostrar el estado del juego.
     */
	public void execute(GameModel game, GameView gameview) {
		game.reset();
		gameview.showGame();
	}
}

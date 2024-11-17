package tp1.control.command;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 * Clase que representa el comando de actualización del estado del juego.
 * Este comando permite actualizar el modelo del juego y mostrar la vista actualizada.
 * 
 * <p>Esta clase extiende {@link NoParamsCommand} y se encarga de gestionar la actualización
 * del estado del juego y la visualización de los cambios en la interfaz del jugador.</p>
 */
public class UpdateCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;
	
    /**
     * Constructor que inicializa el comando con su nombre, atajo, detalles y ayuda.
     */
	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    /**
     * Ejecuta el comando update, actualizando el modelo del juego y mostrando
     * la vista actualizada.
     *
     * @param game El modelo del juego, utilizado para actualizar el estado del juego.
     * @param gameview La vista del juego, utilizada para mostrar el estado actualizado del juego.
     */
	public void execute(GameModel game, GameView gameview) {
		game.update();
		gameview.showGame();
	}
	
    /**
     * Verifica si el comando recibido coincide con el nombre o el atajo del comando.
     *
     * @param command El comando a verificar.
     * @return true si el comando coincide con el nombre o atajo, o si está vacío; false en caso contrario.
     */
	@Override
	protected boolean matchCommand(String command) {
		if( command.equalsIgnoreCase(name) || command.equalsIgnoreCase(shortcut) || command.equals("")) return true;
		else return false;
	}
	
}

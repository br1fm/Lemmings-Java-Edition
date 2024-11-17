package tp1.control.command;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 * Clase que representa el comando de ayuda dentro del juego.
 * Este comando muestra al jugador una lista de comandos disponibles y su descripción.
 * 
 * <p>Esta clase extiende {@link NoParamsCommand} y permite al jugador obtener
 * información sobre los comandos disponibles en el juego cuando se ejecuta.</p>
 * 
 */
public class HelpCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;

    /**
     * Constructor que inicializa el comando con su nombre, atajo, detalles y ayuda.
     */
	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    /**
     * Ejecuta el comando de ayuda, mostrando al jugador una lista de comandos disponibles
     * y sus descripciones.
     *
     * @param game El modelo del juego.
     * @param gameview La vista del juego, utilizada para mostrar los mensajes de ayuda al jugador.
     */
	public void execute(GameModel game, GameView gameview) {	
		gameview.showMessage(Messages.HELP_AVAILABLE_COMMANDS);
		gameview.showMessage(CommandGenerator.commandHelp());
	}

}

package tp1.control.command;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.GameModel;
import tp1.logic.GameWorld;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 * Clase que representa el comando para asignar un rol a un lemming en una posición específica del tablero.
 * Este comando permite al jugador asignar diferentes roles a los lemmings dentro del juego.
 * 
 * <p>Esta clase extiende {@link Command} y se encarga de manejar la asignación de roles a los lemmings,
 * tomando como entrada un rol y una posición en el tablero, y actualizando el estado del juego en consecuencia.</p>

 */
public class SetRoleCommand extends Command{
	
	private String role;
	private Position pos;
	
	
	private static final String NAME = Messages.COMMAND_SET_ROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SET_ROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SET_ROLE_HELP;
	
    /**
     * Constructor por defecto que inicializa el comando con los valores definidos en {@link Messages}.
     */
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
    /**
     * Constructor que inicializa el comando con un rol y una posición específica.
     * 
     * @param role El rol que se asignará al lemming.
     * @param col La columna de la posición donde se asignará el rol.
     * @param row La fila de la posición donde se asignará el rol.
     */
	public SetRoleCommand(String role, int col, int row) {
		super(NAME, SHORTCUT, DETAILS, HELP);
		this.role = role;
		this.pos = new Position(col, row);
	}
	
    /**
     * Analiza un comando recibido y verifica si este es un comando de asignación de rol.
     *
     * @param command Un arreglo de cadenas que contiene el comando recibido y sus parámetros.
     * @return Un nuevo SetRoleCommand si el comando es válido, o null si no lo es.
     */
	public Command parse(String[] command) {
		
		if(matchCommand(command[0]) && command.length == 4) {
			char caracter = command[2].charAt(0);
			caracter = Character.toLowerCase(caracter);
			int row = (caracter - 'a');
			int col = Integer.parseInt(command[3]);
			return new SetRoleCommand(command[1], col - 1, row);
		}
		return null;
	}

    /**
     * Ejecuta el comando de asignación de rol, asignando el rol al lemming en la posición especificada.
     * 
     * <p>Este método valida que el rol exista, que la posición esté dentro del tablero y que
     * la asignación del rol sea exitosa. Si alguna de estas condiciones falla, muestra un mensaje de error.</p>
     *
     * @param game El modelo del juego, utilizado para gestionar el estado del juego.
     * @param gameview La vista del juego, utilizada para mostrar los resultados del comando.
     */
	public void execute(GameModel game, GameView gameview) {
		LemmingRole r = LemmingRoleFactory.parse(role);
			if(r != null) {
				if(game.isInBoard(pos) && game.setRole(r, pos)) {
					game.update();
					gameview.showGame();
				}
				else gameview.showError(Messages.SET_COMMAND_ERROR);
			}
			
		else {
			String error = Messages.UNKNOWN_COMMAND + Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR + NAME;
			gameview.showError(error);
		}

	}
	
    /**
     * Devuelve el texto de ayuda detallado para el comando de asignación de rol.
	 *
     * @return Un texto de ayuda detallado sobre el comando.
     */
	@Override
	protected String helpText() {
		String str;
		str = HELP + LemmingRoleFactory.roleHelp();
		return str;
	}
	
}

package tp1.control.command;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameModelException;
import tp1.exceptions.RoleParseException;
import tp1.logic.GameModel;
import tp1.view.GameView;

public abstract class Command {
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	
	public Command() {} 
	
	/**
	 * Constructor de la clase Command.
	 * Inicializa el nombre (name), la abreviatura (shortcut), los detalles (details)
	 * y la ayuda (help) del comando.
	 * 
	 * @param name Es una cadena de caracteres (String) donde se almacena el nombre del comando.
	 * @param shortcut Es una cadena de caracteres (String) donde se almacena la abreviatura del comando.
	 * @param details Es una cadena de caracteres (String) donde se almacena el mensaje con los detalles del comando.
	 * @param help Es una cadena de caracteres (String) donde se almacena el mensaje de ayuda del comando.
	 */
	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	/**
	 * Devuelve el valor name de Command.
	 * 
	 * @return El valor del nombre del comando.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Devuelve el valor shortcut de Command.
	 * 
	 * @return El valor de la abreviatura del comando.
	 */
	public String getShortcut() {
		return shortcut;
	}

	/**
	 * Devuelve el valor details de Command.
	 * 
	 * @return El mensaje con los detalles del comando.
	 */
	public String getDetails() {
		return details;
	}
	
	/**
	 * Devuelve el valor help de Command.
	 * 
	 * @return El mensaje de ayuda del comando.
	 */
	public String getHelp() {
		return help;
	}
	
	/**
	 * Comprueba si el String referente al comando coincide con su nombre o abreviatura.
	 * 
	 * @return true si coincide, false en caso contrario.
	 */
	protected boolean matchCommand(String command) {
		if( command.equalsIgnoreCase(name) || command.equalsIgnoreCase(shortcut)) return true;
		else return false;
	}
	
	/**
	 * Devuelve el valor help de Command.
	 * 
	 * @return El mensaje de ayuda del comando.
	 */
	protected String helpText() {
		return help;
	}
	
	/**
	 * Devuelve el valor details de Command.
	 * 
	 * @return El mensaje con los detalles del comando.
	 */
	protected String detailsText() {
		return details;
	}
	
	public abstract Command parse(String[] command) throws CommandParseException;
	
	public abstract void execute(GameModel game, GameView gameview) throws CommandExecuteException;
		
}



package tp1.control.command;

import tp1.exceptions.CommandParseException;
import tp1.view.Messages;

/**
 * Clase abstracta que representa un comando que no requiere parámetros adicionales
 * para ser ejecutado.
 * 
 * <p>Esta clase extiende {@link Command} y se utiliza como base para comandos
 * que no necesitan parámetros específicos al ser invocados. 
 */
public abstract class NoParamsCommand extends Command {

    /**
     * Constructor por defecto que llama al constructor de la clase base {@link Command}.
     */
	public NoParamsCommand() {
		super();
	}

	   /**
     * Constructor que inicializa el comando con su nombre, atajo, detalles y ayuda.
     * 
     * @param nombre El nombre del comando.
     * @param shortcut El atajo del comando.
     * @param details Detalles sobre la funcionalidad del comando.
     * @param help Descripción de ayuda para el comando.
     */
	public NoParamsCommand(String nombre, String shortcut, String details, String help) {
		super(nombre, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Método que analiza un comando recibido y determina si este coincide con el
     * comando actual.
     *
     * @param command Un String[] que contiene el comando recibido y sus
     *                posibles parámetros.
     * @return El comando actual si el nombre del comando coincide, o null
     *         si no coincide.
     */
	public Command parse(String[] command) throws CommandParseException{
		if (command.length < 1 || !matchCommand(command[0]))
	 		return null;
	         
	 	if (command.length == 1 && matchCommand(command[0]))
	 		return this;
	    
	 	throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
	}
	
}

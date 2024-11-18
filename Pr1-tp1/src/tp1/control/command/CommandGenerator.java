package tp1.control.command;

import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class CommandGenerator {
	
    /**
     * Lista de comandos disponibles que pueden ser ejecutados.
     * Esta lista está compuesta por instancias de las clases de cada rol.
     */

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
    		new SetRoleCommand(),
    		new UpdateCommand(),
            new ResetCommand(),
            new HelpCommand(),
            new ExitCommand());
    
    /**
     * Parsea un arreglo de cadenas de texto representando un comando.
     * 
     * @param command un arreglo de cadenas representando el comando a analizar.
     * @return el comando correspondiente si el texto es válido, o null si no se reconoce ningún comando.
     */
    
	public static Command parse(String[] command) {
		
		for(Command i : AVAILABLE_COMMANDS) {
			Command c = i.parse(command);
			if(c != null) {
				return c;
			}
		}
		
		return null;
			
	}
	
    /**
     * Genera una cadena de texto con la descripción de ayuda de todos los comandos disponibles.
     * Esta cadena incluye los detalles y la descripción de cada comando.
     * 
     * @return una cadena de texto con la información de ayuda de todos los comandos disponibles.
     */
	
	public static String commandHelp() { 
		
		String str = "";
		
		for(Command i : AVAILABLE_COMMANDS) {
			str += Messages.HELP_COMMAND_MARGIN + i.detailsText() + Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR + i.helpText() + Messages.NEWLINE;
		}
		
		return str;
			
	}
	
}

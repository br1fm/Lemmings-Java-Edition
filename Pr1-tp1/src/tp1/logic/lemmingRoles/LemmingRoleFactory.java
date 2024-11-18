package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class LemmingRoleFactory {
	
    /**
     * Lista de roles disponibles para los lemmings en el juego. Cada rol define un comportamiento distinto.
     */
	private static final List<AbstractRole> AVAILABLE_ROLES = Arrays.asList(
			new DownCaverRole(),
            new ParachuterRole(),
            new WalkerRole()
    );
	
    /**
     * Parsea un string "input" y devuelve el rol correspondiente.
     * Este método verifica si la entrada coincide con el nombre o atajo de alguno de los roles disponibles.
     * 
     * @param input El texto de entrada que representa el rol a buscar.
     * @return El rol correspondiente si se encuentra una coincidencia, null si no se encuentra ningún rol.
     */
	public static LemmingRole parse(String input) { 
		for(AbstractRole i : AVAILABLE_ROLES) {
			if(i.parse(input) != null) {
				return i;
			}
		}
		return null;
	}
	
    /**
     * Genera una cadena de texto con la ayuda de todos los roles disponibles.
     * Cada rol es descrito con su texto de ayuda, que puede ser utilizado para proporcionar
     * información sobre los roles en la interfaz del usuario.
     * 
     * @return Una cadena de texto con las descripciones de todos los roles disponibles.
     */
	public static String roleHelp() {
		
		String str = "";
		
		for(LemmingRole i : AVAILABLE_ROLES) {
			str += Messages.NEWLINE + Messages.HELP_ROLE_MARGIN + i.helpText();
		}
		
		return str;
	}
	
	
	
}

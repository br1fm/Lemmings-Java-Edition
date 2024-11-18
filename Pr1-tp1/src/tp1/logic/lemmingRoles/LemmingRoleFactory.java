package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class LemmingRoleFactory {
	
	private static final List<AbstractRole> AVAILABLE_ROLES = Arrays.asList(
			new DownCaverRole(),
            new ParachuterRole(),
            new WalkerRole()
    );
	
	/**
     * Analiza una cadena de texto para determinar el rol correspondiente.
     * 
     * @param input La cadena de texto que representa el rol que se desea parsear.
     * @return El rol correspondiente si se encuentra, null en caso contrario.
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
     * Genera una cadena con la descripción de ayuda de todos los roles disponibles.
     * 
     * @return Una cadena que contiene la descripción de todos los roles y su ayuda asociada.
     */
	public static String roleHelp() {
		
		String str = "";
		
		for(LemmingRole i : AVAILABLE_ROLES) {
			str += Messages.NEWLINE + Messages.HELP_ROLE_MARGIN + i.helpText();
		}
		
		return str;
	}
	
	
	
}

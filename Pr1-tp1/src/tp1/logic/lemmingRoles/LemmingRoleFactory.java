package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

public class LemmingRoleFactory {
	
	private static final List<AbstractRole> AVAILABLE_ROLES = Arrays.asList(
			new DownCaverRole(),
            new ParachuterRole(),
            new WalkerRole()
    );
	
	public static LemmingRole parse(String input) { //ver si cambiar desde AbstractRole el tipo de valor devuelto
		for(AbstractRole i : AVAILABLE_ROLES) {
			if(i.parse(input) != null) {
				return i;
			}
		}
		return null;
	}
	
	public static String roleHelp() {
		
		String str = "";
		
		for(LemmingRole i : AVAILABLE_ROLES) {
			str += '\n' + " " + i.helpText();
		}
		
		return str;
	}
	
	
	
}

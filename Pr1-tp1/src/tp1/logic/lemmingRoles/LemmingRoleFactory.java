package tp1.logic.lemmingRoles;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.RoleParseException;
import tp1.view.Messages;

public class LemmingRoleFactory {
	
	private static final List<AbstractRole> AVAILABLE_ROLES = Arrays.asList(
			new DownCaverRole(),
            new ParachuterRole(),
            new WalkerRole(),
            new HorizontalCaverRole(),
            new CaverRole(),
            new BlockerRole()
    );
	
	public static LemmingRole parse(String[] input) throws RoleParseException{ 
		for(AbstractRole i : AVAILABLE_ROLES) {
			if(i.parse(input) != null) {
				return i;
			}
		}
		throw new RoleParseException("Unknown role: " + input);
	}
	
	public static String roleHelp() {
		
		String str = "";
		
		for(LemmingRole i : AVAILABLE_ROLES) {
			str += Messages.NEWLINE + Messages.HELP_ROLE_MARGIN + i.helpText();
		}
		
		return str;
	}
	
	
	
}

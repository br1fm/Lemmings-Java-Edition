package tp1.control.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tp1.view.Messages;

public class CommandGenerator {

    private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
            new UpdateCommand(),
            new ResetCommand(),
            new HelpCommand(),
            new ExitCommand());
    
	public static Command parse(String[] command) {
		
		for(Command i : AVAILABLE_COMMANDS) {
			if(i.parse(command) != null) {
				return i;
			}
		}
		
		return null;
			
	}
	
	public static String commandHelp() { 
		
		String str = "";
		
		for(Command i : AVAILABLE_COMMANDS) {
			
			str += i.detailsText() + Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR + " "+ i.helpText() + '\n';
		}
		
		return str;
			
	}
	
}

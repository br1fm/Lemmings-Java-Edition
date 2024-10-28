package tp1.control;

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
		

	}
	
}

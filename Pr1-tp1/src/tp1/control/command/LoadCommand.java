package tp1.control.command;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.GameLoadException;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class LoadCommand extends Command{
	
	private static final String NAME = Messages.COMMAND_LOAD_NAME;
	private static final String SHORTCUT = Messages.COMMAND_LOAD_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_LOAD_DETAILS;
	private static final String HELP = Messages.COMMAND_LOAD_HELP;
	
	private String file;
	
	public LoadCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	public LoadCommand(String file) {
		super(NAME, SHORTCUT, DETAILS, HELP);
		this.file = file;
	}

	@Override
	public Command parse(String[] command) throws CommandParseException {
		
		if(matchCommand(command[0])) {
			if(command.length == 2) return new LoadCommand(command[1]);
			else throw new CommandParseException("Incorrect parameter number");
		}
		else return null;
	}

	@Override
	public void execute(GameModel game, GameView gameview) throws CommandExecuteException {
		try {
			game.load(this.file);
			gameview.showGame();
			
		} catch (GameLoadException e) {
			throw new CommandExecuteException("Invalid file \"" + this.file + "\" configuration", e); 
		}
		
	}
}

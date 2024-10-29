package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand {
	
	private static final String NAME = Messages.COMMAND_HELP_NAME;
	private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_HELP_HELP;

	public HelpCommand(){
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	protected boolean matchCommand(String command) {
		if( command.equals(Messages.COMMAND_HELP_NAME) || command.equals(Messages.COMMAND_HELP_SHORTCUT)) return true;
		else return false;
	}
	
	public Command parse(String[] command) {
		if( command.equals(Messages.COMMAND_HELP_NAME) || command.equals(Messages.COMMAND_HELP_SHORTCUT)) return this;
		else return null;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}

}

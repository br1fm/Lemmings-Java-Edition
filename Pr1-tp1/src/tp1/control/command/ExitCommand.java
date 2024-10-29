package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand {

	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;
	
	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean matchCommand(String command) {
		if( command.equals(NAME) || command.equals(SHORTCUT)) return true;
		else return false;
	}
	
	public Command parse(String[] command) {
		if( command.equals(NAME) || command.equals(SHORTCUT)) return this;
		else return null;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}
	
}

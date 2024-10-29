package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends Command {
	
	private static final String NAME = Messages.COMMAND_NONE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_NONE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_NONE_DETAILS;
	private static final String HELP = Messages.COMMAND_NONE_HELP;
	
	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	protected boolean matchCommand(String command) {
		if( command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)) return true;
		else return false;
	}
	
	public Command parse(String[] command) {
		if( command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)) return this;
		else return null;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}

}

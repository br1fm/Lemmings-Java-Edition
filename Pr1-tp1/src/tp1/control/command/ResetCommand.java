package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends NoParamsCommand {
	
	private static final String NAME = "reset";
	private static final String SHORTCUT = "r";
	private static final String DETAILS = "";
	private static final String HELP = "";
	
	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	protected boolean matchCommand(String command) {
		if( command.equals(NAME) || command.equals(SHORTCUT)) return true;
		else return false;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}

}

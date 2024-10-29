package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class UpdateCommand extends Command {
	
	public UpdateCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateCommand(String nombre, String shortcut, String details, String help) {
		super(nombre, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}

	protected boolean matchCommand(String command) {
		if( command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)) return true;
		else return false;
	}
	
	public Command parse(String[] command) {
		if( command.equals(Messages.COMMAND_NONE_NAME) || command.equals(Messages.COMMAND_NONE_SHORTCUT)) {
			Command c = new UpdateCommand(Messages.COMMAND_NONE_NAME, Messages.COMMAND_NONE_SHORTCUT, Messages.COMMAND_NONE_DETAILS, Messages.COMMAND_NONE_DETAILS);
			return c;
		}
		else return null;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}

}

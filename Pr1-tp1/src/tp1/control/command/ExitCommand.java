package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends Command {

	public ExitCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExitCommand(String nombre, String shortcut, String details, String help) {
		super(nombre, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean matchCommand(String command) {
		if( command.equals(Messages.COMMAND_EXIT_NAME) || command.equals(Messages.COMMAND_EXIT_SHORTCUT)) return true;
		else return false;
	}
	
	public Command parse(String[] command) {
		if( command.equals(Messages.COMMAND_EXIT_NAME) || command.equals(Messages.COMMAND_EXIT_SHORTCUT)) {
			Command c = new ExitCommand(Messages.COMMAND_EXIT_NAME, Messages.COMMAND_EXIT_SHORTCUT, Messages.COMMAND_EXIT_HELP, Messages.COMMAND_EXIT_DETAILS);
			return c;
		}
		else return null;
	}
	
	public void execute(Game game, GameView gameview) {
		
	}
	

}

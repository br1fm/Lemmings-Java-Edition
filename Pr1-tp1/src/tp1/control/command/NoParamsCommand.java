package tp1.control.command;
import tp1.logic.GameModel;
import tp1.view.GameView;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand() {
		super();
	}

	public NoParamsCommand(String nombre, String shortcut, String details, String help) {
		super(nombre, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	
	public Command parse(String[] command) {
		if(matchCommand(command[0])) 
			return this;
		else return null;
	}
	
}

package tp1.control;
import tp1.logic.Game;
import tp1.view.GameView;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoParamsCommand(String nombre, String shortcut, String details, String help) {
	
		super(nombre, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	

}

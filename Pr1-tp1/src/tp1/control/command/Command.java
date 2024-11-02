package tp1.control.command;
import tp1.logic.Game;
import tp1.view.GameView;

public abstract class Command {
	protected String name;
	protected String shortcut;
	protected String details;
	protected String help;
	
	public Command() {} //NO SÉ SI SERÁ NECESARIO CREAR UN CONSTRUCTOR VACÍO
	
	public Command(String nombre, String shortcut, String details, String help) {
		this.name = nombre;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public String getName() {
		return name;
	}

	public String getShortcut() {
		return shortcut;
	}

	public String getDetails() {
		return details;
	}

	public String getHelp() {
		return help;
	}
	
	protected boolean matchCommand(String command) {
		if( command.equalsIgnoreCase(name) || command.equalsIgnoreCase(shortcut)) return true;
		else return false;
	}
	
	protected String helpText() {
		return help;
	}
	
	protected String detailsText() {
		return details;
	}
	
	public abstract Command parse(String[] command);
	public abstract void execute(Game game, GameView gameview);
		
}



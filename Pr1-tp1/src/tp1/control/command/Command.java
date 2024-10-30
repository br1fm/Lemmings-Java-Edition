package tp1.control.command;

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
		if( command.equals(name) || command.equals(shortcut)) return true;
		else return false;
	}
	
	protected String helpText() {
		return help;
	}
	
	public abstract Command parse(String[] command);
		
}



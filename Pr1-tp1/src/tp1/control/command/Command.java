package tp1.control.command;

public abstract class Command {
	protected String nombre;
	protected String shortcut;
	protected String details;
	protected String help;
	
	public Command() {} //NO SÉ SI SERÁ NECESARIO CREAR UN CONSTRUCTOR VACÍO
	
	public Command(String nombre, String shortcut, String details, String help) {
		this.nombre = nombre;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public String getNombre() {
		return nombre;
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
	
	protected abstract boolean matchCommand(String command);
	
	public abstract Command parse(String[] command);
		
}



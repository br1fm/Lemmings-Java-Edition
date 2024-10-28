package tp1.control;

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


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getShortcut() {
		return shortcut;
	}


	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public String getHelp() {
		return help;
	}


	public void setHelp(String help) {
		this.help = help;
	}
	
	
	
	
	
}



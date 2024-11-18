package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public abstract class AbstractRole implements LemmingRole{
	
	private String name;
	private String shortcut;
	private String details;
	
	/**
	 * Constructor para inicializar un rol abstracto.
	 * 
	 * @param name El nombre del rol.
	 * @param shortcut El atajo que representa el rol.
	 * @param details Los detalles descriptivos sobre el rol.
	 */
	AbstractRole(String name, String shortcut, String details){
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
	}
	
	/**
	 * La constante que define el valor máximo de caída para el lemming que tiene el rol.
	 */
	protected final int MAX_FALL = 2;
	
	@Override
	public boolean receiveInteraction(GameItem other, Lemming owner) { return false; }
	
	@Override
    public boolean interactWith(Lemming receiver, Lemming owner) { return false; }
	
	@Override
    public boolean interactWith(Wall wall, Lemming owner) { return false; }
	
	@Override
    public boolean interactWith(ExitDoor door, Lemming owner) { return false; }
    
	@Override
	public void start(Lemming lemming) {
		lemming.setRole(this);
	}
    
    @Override
    public String helpText() {
		return details;
	}
    
    @Override
    public LemmingRole parse(String role) {
		if(role.equalsIgnoreCase(name) || role.equalsIgnoreCase(shortcut)){
			return new WalkerRole();
		}
		return null;
	}
	
}

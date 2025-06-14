package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.lemmingRoles.WalkerRole;

/**
 * Clase que representa un lemming en el juego, que se mueve y interactúa con el entorno.
 */
public class Lemming extends GameObject{

	private Direction dir;
	private int fall_force;
	private LemmingRole role;
	
	/**
	 * Constructor de la clase Lemming.
	 * 
	 * @param pos La posición inicial del lemming.
	 * @param game El juego en el que está el lemming.
	 */
	public Lemming(Position pos, GameWorld game, LemmingRole role, Direction dir, int fall_force) {
		super(pos, game);
		this.dir = dir;
		this.fall_force = fall_force;
		this.role = role;
	}
	
	// Constructor de copia profunda
    protected Lemming(Lemming other) {
        super(other);
        this.role = other.role;
        this.dir = other.dir;
        this.fall_force = other.fall_force;
    }
	
	public Lemming() {}

	/**
	 * Actualiza el estado del lemming en cada ciclo del juego.
	 * Si el lemming está vivo, verifica si ha llegado a la puerta de salida o si debe moverse.
	 */
	@Override
	public void update() {
		if(!isOut() || !isStopped()){
			interact();
			role.play(this);
		}
		else escape();
	}
	
	/**
	 * Mueve al lemming según su estado y las condiciones del juego.
	 * Si no está en el suelo, intenta caer; si está en el suelo, puede caminar o morir.
	 */
	
	@Override
	protected String getName() {
		return "lemming";
	}
	
	/**
	 * Devuelve la dirección actual del lemming.
	 * 
	 * @return La dirección del lemming.
	 */
	public Direction getDirection() {
		return dir;
	}
	
	/**
	 * Hace que el lemming caiga a la posición inmediatamente abajo.
	 */
	public void fall() {
		updatePosition(Direction.DOWN);
		fall_force++;
		if(this.isAtVoid()) this.die();
	}
	
	/**
	 * Hace que el lemming camine en la dirección actual.
	 * Cambia la dirección si hay una pared o si el lemming está en el borde.
	 */
	public void walk() {
		updatePosition(dir);
		if(isSolidAtPos() || isAtBorder()) {
			changeDirection();
			updatePosition(dir);
		}
	}
	
	public void disableRole() {
		role = new WalkerRole();
	}
	
	@Override
	public boolean setRole(LemmingRole role) {
		if(!this.role.equals(role)) {
			this.role = role;
			return true;
		}
		return false;
	}
	
	/**
	 * Devuelve un String del lemming.
	 * 
	 * @return Un string que representa al lemming según su rol.
	 */
	@Override
	public String toString() {
		return role.getIcon(this);
	}
	
	@Override
	public boolean interactWith(Wall wall) {
		return role.interactWith(wall, this);
	}
	
	@Override
	public boolean interactWith(Lemming lemming) {
		return role.interactWith(lemming, this);
	}

	@Override
	public boolean receiveInteraction(GameItem other) {
		return role.receiveInteraction(other, this);
	}
	
	public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException{
		try {
			String[] words = line.trim().split("\\s+");
			if(!getObjectNameFrom(words[1])) return null;
			else {
				Position p = getPositionFrom(words[0], game);
				Direction d = getLemmingDirectionFrom(words[2]);
				int ff = getLemmingHeigthFrom(words[3]);
				LemmingRole lr = getLemmingRoleFrom(words);
				return new Lemming(p, game, lr, d, ff);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new ObjectParseException("Not enough arguments in Lemming: ");
		}
		
	}
	
	private static Direction getLemmingDirectionFrom(String line) throws ObjectParseException {
			Direction d = Direction.NONE;
			d = d.getDirection(line.toUpperCase());
			if(d == null) throw new ObjectParseException("Invalid lemming direction: ");
			return d;
	}
	
	private static int getLemmingHeigthFrom(String line) throws ObjectParseException {
		try {
			int ff = Integer.parseInt(line);
			return ff;
		}catch(NumberFormatException e) {
			throw new ObjectParseException("Lemming height from ground must be a number: ");
		}
	}
	
	private static LemmingRole getLemmingRoleFrom(String[] line) throws ObjectParseException {
		try {
			LemmingRole lr = LemmingRoleFactory.parse(line);
			return lr;
		} catch (RoleParseException e) {
			throw new ObjectParseException("Invalid lemming role: ");
		}
	}

	/**
	 *  Resetea el valor de la fuerza de caída, estableciendo su valor a 0.
	 */
	public void resetFall_force() {
		fall_force = 0;
	}
	
	/**
	 * Devuelve el valor de la fuerza de caída.
	 * @return fall_force entero que indica fuerza de caída del lemming.
	 */
	public int getFall_force() {
		return fall_force;
	}
	
	@Override
	protected String getShortcut() {
		return "l";
	}

    @Override
    public GameObject copy() {
        return new Lemming(this);
    }
    
    public void changeDirection() {
    	dir = dir.changeDirection();
    }
    
    @Override
	public boolean isSolid(){
		return role.isSolid();
	}
    
}

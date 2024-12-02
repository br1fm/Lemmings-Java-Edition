package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Direction;
import tp1.logic.GameWorld;

public abstract class GameObject implements GameItem{
	
	private Position pos;
	private boolean is_alive, is_out;
	private GameWorld game;
	
	GameObject(Position pos, GameWorld game){
		this.game = game;
		this.pos = pos;
		this.is_out = false;
		is_alive = true;
	}
	
	protected GameObject(GameObject other) {
        this.pos = new Position(other.pos);
        this.game = other.game;
        this.is_out = false;
		is_alive = true;
    }
	
	GameObject(){}
	
	/**
	 * Actualiza el estado del objeto en cada ciclo del juego.
	 */
	public void update() {};
	
	/**
	 * Comprueba si el objeto ha escapado del nivel.
	 * 
	 * @return true si el objeto ha escapado, false en caso contrario.
	 */
	public boolean isFreed() {
		return is_out;
	}
	
	/**
	 * Marca el objeto como escapado del nivel.
	 */
	public void escape() {
		is_out = true;
	}
	
	/**
	 * Marca el objeto como muerto.
	 */
	public void die() {
		is_alive = false;
	}
	
	/**
	 * Actualiza la posición del objeto según la dirección proporcionada.
	 * 
	 * @param dir La dirección en la que se quiere mover el objeto.
	 * @return La nueva posición del objeto después de moverse.
	 */
	protected Position updatePosition(Direction dir) {
		pos = pos.nextPosition(dir);
		return pos;
	}
	
	/**
	 * Comprueba si el objeto está en el suelo.
	 * 
	 * @return true si el objeto está en el suelo, false en caso contrario.
	 */
	public boolean isOnGround() {
		return (game.isSolidAtPos(pos.nextPosition(Direction.DOWN)));
	}
	
	/**
	 * Comprueba si el objeto está en una posición relativa a otra posición especificada en una dirección dada.
	 * 
	 * @param other La posición con la que se quiere comparar.
	 * @param dir La dirección relativa en la que se busca la comparación.
	 * @return true si el objeto está en la posición relativa especificada, false en caso contrario.
	 */
	public boolean isOnRelativePos(Position other, Direction dir){
		Position aux = pos.nextPosition(dir);
		return (aux.equals(other));
	}
	
	/**
	 * Verifica si el objeto está en el vacío utilizando la función isAtVoid de {@link Game#isAtVoid(Position pos)}.
	 * 
	 * @return true si la función de Game devuelve true, false en caso contrario.
	 */
	public boolean isAtVoid() {
		return game.isAtVoid(pos);
	}


	/**
	 * Comprueba si la posición actual del objeto está ocupada por un elemento sólido.
	 * 
	 * @return true si la posición es sólida, false en caso contrario.
	 */
	public boolean isSolidAtPos() {
		return game.isSolidAtPos(pos);
	}
	

	/**
	 * Comprueba si el objeto está en el borde del mundo del juego.
	 * 
	 * @return true si el objeto está en el borde, false en caso contrario.
	 */
	public boolean isAtBorder() {
		return game.isAtBorder(pos);
	}
	
	public boolean isOut() {
		return game.isExitAtPos(pos);
	}
	
	public boolean setRole(LemmingRole role) {
		return false;
	}
	
	/**
	 * Devuelve la posición actual del objeto.
	 * 
	 * @return La posición actual del objeto.
	 */
	public Position getPos() {
		return pos;
	}
	
	/**
	 * Permite que el objeto interactúe con otros elementos en el juego.
	 * 
	 * @return true si la interacción fue exitosa, false en caso contrario.
	 */
	public boolean interact() {
		return game.receiveInteractionsFrom(this);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}
	
	@Override
	public boolean isExit() {
		return false;
	}
	
	@Override
	public boolean isAlive() {
		return is_alive;
	}
	
	@Override
	public boolean isInPosition(Position pos) {
		return (pos.equals(this.pos));
	}
	
	//NUEVO
	public abstract GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException;
	
	protected Position getPositionFrom(String line, GameWorld game) throws ObjectParseException, OffBoardException {
		
		try {
			
			String[] p = line.substring(1, line.length() - 1).split(",");
			
            int row = Integer.parseInt(p[0]);
            int col = Integer.parseInt(p[1]);
            
            Position pos = new Position(col, row);
            if(!game.isInBoard(pos)) throw new OffBoardException("Object position is off board: ");
            return pos;
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException | NullPointerException e) {
			throw new ObjectParseException("Invalid object position: ");
		}
		
	}
	
	protected boolean getObjectNameFrom(String line) throws ObjectParseException{
		
		try {
			
			if(!line.toLowerCase().equals(getName()) && !line.toLowerCase().equals(getShortcut())) {
				return false;
			}
			else return true;
			
		}catch(NullPointerException e) {
			throw new ObjectParseException("Unknown game object: ");
		}
	}

	protected abstract String getName();
	
	protected abstract String getShortcut();
	
	@Override
	public boolean interactWith(Lemming lemming) { return false; }
	
	@Override
	public boolean interactWith(Wall wall) { return false; }
	
	@Override
	public boolean interactWith(ExitDoor door) { return false; }

	public abstract GameObject copy();
	
}

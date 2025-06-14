package tp1.logic;

public enum Direction {
	LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), NONE(0,0), LEFT_DOWN(-1,1), RIGHT_DOWN(1,1), RIGHT_UP(1,-1), LEFT_UP(-1,-1);
	
	private int x;
	private int y;
	
	/**
	 * Constructor de la enumeración Direction.
	 * Inicializa los valores X e Y para la dirección.
	 * 
	 * @param x Valor del eje X.
	 * @param y Valor del eje Y.
	 */
	private Direction(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Devuelve el valor X de Direction.
	 * 
	 * @return El valor del eje X.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Devuelve el valor Y de Direction.
	 * 
	 * @return El valor del eje Y.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * .Cambia la dirección this.
	 * 
	 * @return El nuevo valor de this; si era RIGHT a LEFT, si era LEFT a RIGHT,
	 * si era UP a DOWN y si era de DONW a UP.
	 */
	public Direction changeDirection() {
		Direction aux;
		
		switch(this) {
		case LEFT:
			aux = RIGHT;
			break;
		case RIGHT:
			aux = LEFT;
			break;
		case UP:
			aux = DOWN;
			break;
		case DOWN:
			aux = UP;
			break;
		default:
			aux = NONE;
		}
		
		return aux;
	}
	
	public Direction getDirection(String dir) {
		Direction aux;
		dir = dir.toUpperCase();
		
		switch(dir) {
		case "LEFT":
			aux = LEFT;
			break;
		case "RIGHT":
			aux = RIGHT;
			break;
		case "UP":
			aux = UP;
			break;
		case "DOWN":
			aux = DOWN;
			break;
		case "LEFT_DOWN":
			aux = LEFT_DOWN;
			break;
		case "RIGHT_DOWN":
			aux = RIGHT_DOWN;
			break;
		case "RIGHT_UP":
			aux = RIGHT_UP;
			break;
		case "LEFT_UP":
			aux = LEFT_UP;
			break;
		default:
			aux = null;
		}
		return aux;
	}
	
}

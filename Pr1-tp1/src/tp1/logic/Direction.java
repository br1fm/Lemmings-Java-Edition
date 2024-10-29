package tp1.logic;

public enum Direction {
	LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	
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

	public void changeDirection(Direction dir) {
		if(dir.equals(LEFT)) dir = RIGHT;
		else dir = LEFT;
	}
	
	
}

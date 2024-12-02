package tp1.logic;

/**
 * Clase que representa una posición en el tablero del juego, con coordenadas de columna y fila.
 * La clase es inmutable.
 */
public final class Position {

	private final int col;
	private final int row;
		
	/**
	 * Constructor de la clase Position.
	 * 
	 * @param col Columna de la posición.
	 * @param row Fila de la posición.
	 */
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	/**
     * Constructor de copia profunda.
     * 
     * @param other La posición que se quiere copiar.
     */
    public Position(Position other) {
        this.col = other.col;
        this.row = other.row;
    }
	
	/**
	 * Compara esta posición con otra posición proporcionada.
	 * 
	 * @param other_pos La posición con la que se va a comparar.
	 * @return true si ambas posiciones son iguales, false en caso contrario.
	 */
	public boolean equals(Position other_pos) {
	       if (this == other_pos) return true; 
	       if (other_pos == null) return false;
	       return (col == other_pos.col && row == other_pos.row); 
	 }
	
	/**
	 * Devuelve la columna de esta posición.
	 * 
	 * @return El valor de la columna.
	 */
	 public int getCol() {
		 return col;
	 }
	 
	 /**
	 * Devuelve la fila de esta posición.
	 * 
	 * @return El valor de la fila.
	 */
	 public int getRow() {
		 return row;
	 }
	 
	 /**
	 * Devuelve la posicion actualizada al aplicar una cierta dirección.
	 * 
	 * @param dir parametro de tipo Direction que indica la direccion de la siguiente posicion.
	 * @return La siguiente posicion.
	 */
	 public Position nextPosition(Direction dir) {
		 Position pos = new Position(col + dir.getX(), row + dir.getY());
		 return pos;
	 }
	 
}

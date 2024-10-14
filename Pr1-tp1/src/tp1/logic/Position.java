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
	 * Compara esta posición con otra posición proporcionada.
	 * 
	 * @param other_pos La posición con la que se va a comparar.
	 * @return true si ambas posiciones son iguales, false en caso contrario.
	 */
	public boolean equals(Position other_pos) {
	       if (this == other_pos) return true; 
	       if (other_pos == null) return false;
	       return (col == other_pos.col && row == other_pos.row); // Compara atributos
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
	 * Comprueba si la posición está en el borde del tablero.
	 * 
	 * @return true si la posición está en el borde, false en caso contrario.
	 */
	 public boolean isAtBorder() {
			return (this.col == Game.DIM_X||
					this.col == -1);
	}
		
	 /**
	 * Comprueba si la posición está fuera del tablero (en el vacío).
	 * 
	 * @return true si la posición está en el vacío, false en caso contrario.
	 */
	public boolean isAtVoid() {
			return (this.row == Game.DIM_Y);
	}
	 
}

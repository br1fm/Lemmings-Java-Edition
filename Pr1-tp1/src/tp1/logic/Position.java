package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public final class Position {

	private final int col;
	private final int row;
	
	//TODO fill your code
	
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	 public boolean equals(Position other_pos) {
	       if (this == other_pos) return true; 
	       if (other_pos == null) return false;
	       return (col == other_pos.col && row == other_pos.row); // Compara atributos
	 }
	
	 public int getCol() {
		 return col;
	 }
	 
	 public int getRow() {
		 return row;
	 }
	 
	 public boolean isAtBorder() {
			return (this.col == Game.DIM_X||
					this.col == -1);
	}
		
	public boolean isAtVoid() {
			return (this.row == Game.DIM_Y);
	}
	 
}

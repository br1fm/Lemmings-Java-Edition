package tp1.logic.gameobjects;

import tp1.logic.Position;

public interface GameItem {
	
	/**
	 * Permite que el objeto reciba una interacción de otro elemento del juego.
	 * 
	 * @param other El objeto del juego que interactúa con este objeto.
	 * @return true si la interacción fue exitosa, false en caso contrario.
	 */
	public boolean receiveInteraction(GameItem other);

	/**
	 * Define la interacción del objeto con un lemming.
	 * 
	 * @param lemming El lemming con el que se quiere interactuar.
	 * @return true si la interacción fue exitosa, false en caso contrario.
	 */
	public boolean interactWith(Lemming lemming);
	
	/**
	 * Define la interacción del objeto con una pared.
	 * 
	 * @param wall La pared con la que se quiere interactuar.
	 * @return true si la interacción fue exitosa, false en caso contrario.
	 */
	public boolean interactWith(Wall wall);
	
	/**
	 * Define la interacción del objeto con una puerta de salida.
	 * 
	 * @param door La puerta de salida con la que se quiere interactuar.
	 * @return true si la interacción fue exitosa, false en caso contrario.
	 */
	public boolean interactWith(ExitDoor door);

	/**
	 * Comprueba si el objeto es sólido.
	 * 
	 * @return true si el objeto es sólido, false en caso contrario.
	 */
	public boolean isSolid();
	
	/**
	 * Comprueba si el objeto está vivo.
	 * 
	 * @return true si el objeto está vivo, false en caso contrario.
	 */
	public boolean isAlive();
	
	/**
	 * Comprueba si el objeto es una salida.
	 * 
	 * @return true si el objeto es una salida, false en caso contrario.
	 */
	public boolean isExit();
	

	/**
	 * Comprueba si el objeto está en la posición especificada.
	 * 
	 * @param pos La posición con la que se va a comparar.
	 * @return true si el objeto está en la posición proporcionada, false en caso contrario.
	 */
	public boolean isInPosition(Position pos);
}

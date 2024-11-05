package tp1.logic;
import tp1.logic.gameobjects.Lemming;

import tp1.logic.gameobjects.Wall;

import java.util.ArrayList;

import java.util.List;

import tp1.logic.gameobjects.ExitDoor;

import tp1.logic.gameobjects.GameObject;

/**
 * Contenedor de objetos del juego, gestiona los lemmings, las paredes y la puerta de salida.
 */
public class GameObjectContainer {

	private List<GameObject> gameObjects;
	private ExitDoor exitDoor;
	private int dead_lemmings = 0;
	private int freed_lemmings = 0;
	
	
	/*
	public GameObjectContainer() {
		arrayLemmings = new ArrayList<>();
		arrayWalls = new ArrayList<>();
	}*/
	
	/**
	 * Constructor de la clase GameObjectContainer.
	 * Inicializa la lista de objetos.
	 */
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	/**
	 * Añade un objeto al contenedor.
	 * 
	 * @param o Objeto GameObject a añadir.
	 */
    public void add(GameObject o) {
    	gameObjects.add(o);
    }
	
    /**
	 * Actualiza el estado de todos los objetos en el contenedor,
	 * incluyendo lemmings y paredes, y elimina lemmings muertos o liberados.
	 */
    public void update() {
    	
    	for(GameObject o : gameObjects) {
    		if(o.isAlive()) o.update();
    	}
    	
    	//QUITAR
    	removeDeadLemmings();
    	removeFreedLemmings();
    	
    }
    
    /**
	 * Devuelve el número de lemmings que están actualmente en el tablero.
	 * 
	 * @return Número de lemmings en el tablero.
	 */
    public int numLemmingsInBoard() {
    	return arrayLemmings.size();
    }
    
    /**
	 * Devuelve el número de lemmings que han muerto.
	 * 
	 * @return Número de lemmings muertos.
	 */
    public int numLemmingsDead() {
    	return dead_lemmings;
    }
    
    /**
	 * Devuelve el número de lemmings que han alcanzado la exit door.
	 * 
	 * @return Número de lemmings que han salido.
	 */
    public int numLemmingsExit() {
    	return freed_lemmings;
    }
    
    /**
	 * Comprueba si hay una wall en la posición especificada.
	 * 
	 * @param comparison Objeto Position a comparar.
	 * @return true si hay una pared en la posición, false en caso contrario.
	 */
    public boolean isWallAtPos(Position comparison) {
    	
    	//isSolid??
    	
    	/*int i = 0;
    	boolean stop = false;
    	while(i < arrayWalls.size() && !stop) {
    		if(arrayWalls.get(i).isAtPosition(comparison)) stop = true;
    		i++;
    	}
    		
    	return (i < arrayWalls.size() || stop);
    	*/
    	
    	int i = 0;
    	boolean stop = false;
    	while(i < gameObjects.size() && !stop) {
    		if(gameObjects.get(i).isAtPosition(comparison) && gameObjects.get(i).isSolid()) stop = true;
    		i++;
    	}
    		
    	return (i < gameObjects.size() || stop);
    	
    }
    
    /**
	 * Comprueba si hay una puerta de salida en la posición especificada.
	 * 
	 * @param comparison Objeto Position a comparar.
	 * @return true si hay una puerta de salida en la posición, false en caso contrario.
	 */
    public boolean isDoorAtPos(Position comparison) {
    	return (exitDoor.isAtPosition(comparison));
    }
    
    /**
	 * Devuelve una representación del contenido de una posición del tablero.
	 * 
	 * @param col Columna de la posición.
	 * @param row Fila de la posición.
	 * @return Representación en cadena del objeto en la posición.
	 */
    public String positionToString(int col, int row) {
    	
    	StringBuilder res = new StringBuilder(5);
    	String str = null;
    	Position pos = new Position(col, row);
    	
    	for(GameObject o : gameObjects) {
    		if(o.isAtPosition(pos)) {
    			res.append(o);
    		}
    	}
    	
    	str = res.toString();
    	
    	return str;
    }
    
    /**
	 * Elimina un objeto de la lista de objetos.
	 * Actualiza el contador de lemmings muertos o libres.
	 * @param o El objeto GameObject a eliminar.
	 */
    public void removeObject(GameObject o) {
    	gameObjects.remove(o);
    	if(o.isAlive()) freed_lemmings++;
    	else dead_lemmings++;
    }
    
}

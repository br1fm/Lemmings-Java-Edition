package tp1.logic;

import java.util.ArrayList;

import java.util.List;

import tp1.logic.gameobjects.GameObject;
import tp1.logic.lemmingRoles.LemmingRole;

/**
 * Contenedor de objetos del juego, gestiona los lemmings, las paredes y la puerta de salida.
 */
public class GameObjectContainer {

	private List<GameObject> gameObjects;
	private int dead_lemmings = 0;
	private int freed_lemmings = 0;
	
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
    	
    	removeObjects();
    }
    
    /**
	 * Devuelve el número de lemmings que están actualmente en el tablero.
	 * 
	 * @return Número de lemmings en el tablero.
	 */
    public int numLemmingsInBoard() { //TODO: CAMBIAR.
    	return 3;
    	//return arrayLemmings.size();
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
    	
    	int i = 0;
    	boolean stop = false;
    	while(i < gameObjects.size() && !stop) {
    		if(gameObjects.get(i).isAtPosition(comparison) && gameObjects.get(i).isExit()) stop = true;
    		i++;
    	}
    		
    	return (i < gameObjects.size() || stop);
    	
    }
    
    /**
	 * Devuelve una representación del contenido de una posición del tablero.
	 * 
	 * @param col Columna de la posición.
	 * @param row Fila de la posición.
	 * @return Representación en cadena del objeto en la posición.
	 */
    public String positionToString(int col, int row) {
    	
    	StringBuilder res = new StringBuilder();
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
    
    public void removeObjects() {
        List<GameObject> toRemove = new ArrayList<>();
        for (GameObject o : gameObjects) {
            if (!o.isAlive()) {
                toRemove.add(o);
                dead_lemmings++;
            } else if (o.isFreed()) {
                toRemove.add(o);
                freed_lemmings++;
            }
        }
        gameObjects.removeAll(toRemove);
    }

	public boolean setRole(LemmingRole role, Position comparison) {
		int i = 0;
    	boolean stop = false;
    	while(i < gameObjects.size() && !stop) {
    		if(gameObjects.get(i).isAtPosition(comparison) && gameObjects.get(i).setRole(role)) stop = true;
    		i++;
    	}
    		
    	return (stop);
	}
    
}

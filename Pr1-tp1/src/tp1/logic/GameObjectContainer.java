package tp1.logic;
import tp1.logic.gameobjects.Lemming;

import tp1.logic.gameobjects.Wall;

import java.util.ArrayList;

import tp1.logic.gameobjects.ExitDoor;

/**
 * Contenedor de objetos del juego, gestiona los lemmings, las paredes y la puerta de salida.
 */
public class GameObjectContainer {

	private ArrayList<Lemming> arrayLemmings;
	private ArrayList<Wall> arrayWalls;
	private ExitDoor exitDoor;
	private int dead_lemmings;
	private int freed_lemmings;
	
	/**
	 * Constructor de la clase GameObjectContainer.
	 * Inicializa las listas de lemmings, paredes y los contadores de lemmings muertos y liberados.
	 */
	public GameObjectContainer() {
		arrayLemmings = new ArrayList<>();
		arrayWalls = new ArrayList<>();
		dead_lemmings = 0;
		freed_lemmings = 0;
	}
	
	/**
	 * Añade un lemming al contenedor.
	 * 
	 * @param lemming Objeto Lemming a añadir.
	 */
    public void add(Lemming lemming) {
    	arrayLemmings.add(lemming);
    }
    
    /**
	 * Añade una wall al contenedor.
	 * 
	 * @param wall Objeto Wall a añadir.
	 */
    public void add(Wall wall) {
    	arrayWalls.add(wall);
    }
	
    /**
	 * Añade la exit door al contenedor.
	 * 
	 * @param exitDoor Objeto ExitDoor a añadir.
	 */
    public void add(ExitDoor exitDoor) {
    	this.exitDoor = exitDoor;
    }
	
    /**
	 * Actualiza el estado de todos los objetos en el contenedor,
	 * incluyendo lemmings y paredes, y elimina lemmings muertos o liberados.
	 */
    public void update() {
    	
    	for(Lemming l : arrayLemmings) {
    		l.update();
    	}
    	
    	for(Wall w : arrayWalls) {
    		w.update();
    	}
    	
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
    	
    	int i = 0;
    	boolean stop = false;
    	while(i < arrayWalls.size() && !stop) {
    		if(arrayWalls.get(i).isAtPosition(comparison)) stop = true;
    		i++;
    	}
    		
    	return (i < arrayWalls.size() || stop);
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
    	
    	for(Lemming l : arrayLemmings) {
    		if(l.isAtPosition(pos)) {
    			res.append(l);
    		}
    		
    	}
    	
    	if(exitDoor.isAtPosition(pos)) {
    		res.append(exitDoor);
    	}
    	
    	str = res.toString();
    	
    	for(Wall w : arrayWalls) {
    			if(w.isAtPosition(pos)) str = w.toString();
    	}
    	
    	return str;
    }
    
    /**
	 * Elimina los lemmings muertos de la lista de lemmings.
	 * Actualiza el contador de lemmings muertos.
	 */
    public void removeDeadLemmings() {
    	
        ArrayList<Lemming> tempList = new ArrayList<>();
        for(Lemming l : arrayLemmings) {
            if(l.isAlive()) {
                tempList.add(l);
            }
            else dead_lemmings++;
        }
        
        arrayLemmings = tempList;
    }
    
    /**
	 * Elimina los lemmings que han alcanzado la puerta de salida de la lista de lemmings.
	 * Actualiza el contador de lemmings liberados.
	 */
    public void removeFreedLemmings() {
    	
    	ArrayList<Lemming> tempList = new ArrayList<>();
    	for(Lemming l : arrayLemmings) {
			if(!l.isOut()) {
    			tempList.add(l);
    		}
    		else freed_lemmings++;
    	}
    	
    	arrayLemmings = tempList;
    	
    }
    
}

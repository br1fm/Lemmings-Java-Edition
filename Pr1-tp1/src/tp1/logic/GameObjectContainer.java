package tp1.logic;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;
//CAMBIO: igual hay que cambiar este import.
import tp1.logic.Game;

public class GameObjectContainer {
	//TODO fill your code
	private int l_cont;
	private int w_cont;
	private Lemming[] arrayLemmings;
	private Wall[] arrayWalls;
	private ExitDoor exitDoor;
	
	public GameObjectContainer(int num_lemmings, int num_walls) {
		l_cont = 0;
		w_cont = 0;
		arrayLemmings = new Lemming[num_lemmings];
		arrayWalls = new Wall[num_walls];
	}
	
    public void add(Lemming lemming) {
    	arrayLemmings[l_cont] = lemming;
    	l_cont++;
    }
    
    public void add(Wall wall) {
    	arrayWalls[w_cont] = wall;
    	w_cont++;
    }
	
    public void add(ExitDoor exitDoor) {
    	this.exitDoor = exitDoor;
    }
	
    public void update() {
    	for(Lemming l : arrayLemmings) {
    		l.update();
    	}
    	
    	for(Wall w : arrayWalls) {
    		w.update();
    	}
    }
    
    
    public String positionToString(int col, int row) {
    	
    	String str = "      ";
    	
    	if(arrayLemmings.length > 0) {
        	for(Lemming l : arrayLemmings) {
        		if(l.isAtPosition(col, row)) str = l.toString();
        	}
    	}

 
    	for(Wall w : arrayWalls) {
    		if(w.isAtPosition(col, row)) str = w.toString();
    	}
    	
    	return str;
    }
    
}

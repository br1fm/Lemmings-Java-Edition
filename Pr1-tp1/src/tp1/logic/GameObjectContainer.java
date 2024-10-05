package tp1.logic;
import tp1.logic.gameobjects.Lemming;

import tp1.logic.gameobjects.Wall;

import java.util.ArrayList;

import tp1.logic.gameobjects.ExitDoor;

public class GameObjectContainer {
	//TODO fill your code
	private ArrayList<Lemming> arrayLemmings;
	private ArrayList<Wall> arrayWalls;
	private ExitDoor exitDoor;
	
	public GameObjectContainer() {
		arrayLemmings = new ArrayList<>();
		arrayWalls = new ArrayList<>();
	}
	
    public void add(Lemming lemming) {
    	arrayLemmings.add(lemming);
    }
    
    public void add(Wall wall) {
    	arrayWalls.add(wall);
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
    
    public int numLemmingsBoard() {
    	return arrayLemmings.size();
    }
    
    public boolean isWallAtPos(Position comparison) {
    	
    	boolean condition = false;
    	
    	for(Wall w : arrayWalls) {
    		if(w.isAtPosition(comparison)) condition = true;
    	}
    	return condition;
    }
    
    public String positionToString(int col, int row) {
    	
    	String str = "      ";
    	Position pos = new Position(col, row);
    	
    	
    	for(Lemming l : arrayLemmings) {
    		if(l.isAtPosition(pos)) str = l.toString();
    	}
    	
    	for(Wall w : arrayWalls) {
    			if(w.isAtPosition(pos)) str = w.toString();
    	}
    	
    	return str;
    }
    
}

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
	private int dead_lemmings;
	private int freed_lemmings;
	
	public GameObjectContainer() {
		arrayLemmings = new ArrayList<>();
		arrayWalls = new ArrayList<>();
		dead_lemmings = 0;
		freed_lemmings = 0;
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
    	
    	removeDeadLemmings();
    	removeFreedLemmings();
    	
    }
    
    public int numLemmingsInBoard() {
    	return arrayLemmings.size();
    }
    
    public int numLemmingsDead() {
    	return dead_lemmings;
    }
    
    public int numLemmingsExit() {
    	return freed_lemmings;
    }
    
    public boolean isWallAtPos(Position comparison) {
    	
    	boolean condition = false;
    	
    	for(Wall w : arrayWalls) {
    		if(w.isAtPosition(comparison)) condition = true;
    	}
    	return condition;
    }
    
    public boolean isDoorAtPos(Position comparison) {
    	return (exitDoor.isAtPosition(comparison));
    }
    
    public String positionToString(int col, int row) {
    	
    	StringBuilder res = new StringBuilder(5);
    	String str = "      ";
    	Position pos = new Position(col, row);
    	
    	for(Lemming l : arrayLemmings) {
    		if(l.isAtPosition(pos)) {
    			str = l.toString();
    			res.append(str);
    		}
    		
    	}
    	
    	if(exitDoor.isAtPosition(pos)) {
    		str = exitDoor.toString();
    		res.append(str);
    	}
    	
    	str = res.toString();
    	
    	for(Wall w : arrayWalls) {
    			if(w.isAtPosition(pos)) str = w.toString();
    	}
    	
    	return str;
    }
    
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

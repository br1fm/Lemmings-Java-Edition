package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;

public class WalkerRole {
	
    public void play(Lemming lemming) {
    	lemming.move();
    }
    
    public String getIcon(Lemming lemming){
    	String str;
    	if(lemming.getDirection() == Direction.LEFT) str = "ᗺ";
    	else str = "B";
    	return str;
    }
}
package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.Lemming;

public class WalkerRole {
	
	private Lemming lemming;
	
	public WalkerRole(Lemming lemming) {
		this.lemming = lemming;
	}
	
    public void play() {
    	
    }
    
    @Override
    public String toString(){
    	String str;
    	if(lemming.getDirection() == Direction.RIGHT) str = "B";
    	else str = "ᗺ";
    	return str;
    }
}
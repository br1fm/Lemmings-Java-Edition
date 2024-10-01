package tp1.logic.gameobjects;

import tp1.logic.Direction;

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

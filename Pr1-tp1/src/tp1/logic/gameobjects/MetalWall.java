package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject{

	MetalWall(Position pos, GameWorld game) {
		super(pos, game);
	}

	@Override
	public boolean receiveInteraction(GameItem other) {
		return other.receiveInteraction(this);
	}

	@Override
	public String toString() {
		return Messages.METAL_WALL;
	}
		
	@Override
	public boolean isSolid() {
		return true;
	}
	
}

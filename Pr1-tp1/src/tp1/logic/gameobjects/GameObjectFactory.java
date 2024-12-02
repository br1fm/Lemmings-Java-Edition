package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.GameWorld;
import tp1.logic.lemmingRoles.AbstractRole;

public class GameObjectFactory {
	// lista constante de GameObject’s disponibles
	
	private static final List<GameObject> AVAILABLE_OBJECTS = Arrays.asList(
			new Lemming(),
			new Wall(),
			new MetalWall(),
			new ExitDoor()
		);
	
	public static GameObject parse(String line, GameWorld game)
	throws ObjectParseException, OffBoardException {
		for(GameObject i : AVAILABLE_OBJECTS) {
			GameObject go = i.parse(line, game);
			if(go != null) {
				return go;
			}
		}
		throw new ObjectParseException("Unknown game object: " + line);
	}
		
}

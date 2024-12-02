package tp1.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.GameObjectFactory;

public class FileGameConfiguration implements GameConfiguration {
	
	public static final GameConfiguration NONE = new FileGameConfiguration();
	private int cycle;
	private int numLemmingsInBoard; 
	private int numLemmingsDead;
	private int numLemmingsExit;
	private int numLemmingsToWin;
	private GameObjectContainer gameObjects;
	
	public FileGameConfiguration() {};
	
	public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
		
		// abre el fichero
		// se lee siguiendo el formato esperado, guardando en
		// atributos para poder implementar los getters del interfaz
		// primera línea deberían ser 5 números
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Leer la primera línea y parsear los 5 números
			String firstLine = reader.readLine();
			try {
            String[] numbers = firstLine.trim().split("\\s+");
                cycle = Integer.parseInt(numbers[0]);
                numLemmingsInBoard = Integer.parseInt(numbers[1]);
                numLemmingsDead = Integer.parseInt(numbers[2]);
                numLemmingsExit = Integer.parseInt(numbers[3]);
                numLemmingsToWin = Integer.parseInt(numbers[4]);
            }catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
                throw new GameLoadException("Invalid game status: \"" + firstLine + "\"");
            }
            
            // siguientes deberían poder parsearse con GameObjectFactory
    		// si se produce un error se lanza la GameLoadException
            
            gameObjects = new GameObjectContainer();

            // Leer las siguientes líneas y parsear los objetos del juego
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                	try{
                		GameObject obj = GameObjectFactory.parse(line, game);
                		gameObjects.add(obj);
                	}catch(OffBoardException | ObjectParseException e){
                		throw new GameLoadException(e.getMessage());
                	}
                }
            }
            
		}catch (IOException e) {
        throw new GameLoadException("File not found: \"" + fileName + "\"");
		}
		
	}
	
	// Métodos de GameConfiguration

	@Override
	public int getCycle() {
		return cycle;
	}

	@Override
	public int numLemmingsInBoard() {
		return numLemmingsInBoard;
	}

	@Override
	public int numLemmingsDead() {
		return numLemmingsDead;
	}

	@Override
	public int numLemmingsExit() {
		return numLemmingsExit;
	}

	@Override
	public int numLemmingsToWin() {
		return numLemmingsToWin;
	}

	@Override
	public GameObjectContainer getGameObjects() {
		return gameObjects;
	}
	
}

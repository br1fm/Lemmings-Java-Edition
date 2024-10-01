package tp1.control;

import java.util.Scanner;

import tp1.logic.Game;
import tp1.logic.GameObjectContainer;
import tp1.view.GameView;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 * 
	 */
	public void run() {
		
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		Scanner entrada = new Scanner (System.in);
		String command;
		view.showWelcome();
		view.showGame();
		
		do{
			command = entrada.nextLine();
			command = command.toLowerCase();
				
				switch(command) {
					case "none":
					case "n":
					case "":
						game.update();
						view.showGame();
						//CAMBIO: AÑADIR QUE SUME UN TURNO
					break;
					case "help":
					case "h":
						//System.out.flush();
						help();
					break;
					case "reset":
					case "r":
					break;
					case "exit":
					case "e":
					break;
					default:
						System.out.println("El comando introducido no es correcto");
				}
			
		}while((!command.equals("e")) && (!command.equals("exit")));
		
		entrada.close();
		view.showEndMessage();
	}
	
	private void help(){
		System.out.println(
				"Command > help\n"
				+ "Available commands:\n"
				+ "[r]eset: start a new game\n"
				+ "[h]elp: print this help message\n"
				+ "[e]xit: end the execution of the game\n"
				+ "[n]one | \"\": skips cycle");
	}
	
}

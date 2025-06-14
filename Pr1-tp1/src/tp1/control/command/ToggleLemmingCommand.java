package tp1.control.command;

import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.logic.GameModel;
import tp1.logic.Position;
import tp1.view.GameView;
import tp1.view.Messages;

public class ToggleLemmingCommand extends Command{

	private static final String NAME = Messages.COMMAND_TOGGLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_TOGGLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_TOGGLE_DETAILS;
	private static final String HELP = Messages.COMMAND_TOGGLE_HELP;
	
	private Position pos;
	
	public ToggleLemmingCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	public ToggleLemmingCommand(int col, int row) {
		super(NAME, SHORTCUT, DETAILS, HELP);
		pos = new Position(col, row);
	}
	
	@Override
	public Command parse(String[] command) throws CommandParseException {
		if(matchCommand(command[0])) {
			int row = 0;
			int col = 0;
			
			if(command.length > 3) throw new CommandParseException("Incorrect parameter number");
			
			try {
			char caracter = command[1].charAt(0);
			caracter = Character.toLowerCase(caracter);
			row = (caracter - 'a');
			col = Integer.parseInt(command[2]);
			}catch (NumberFormatException e) {
			 	throw new CommandParseException(Messages.INVALID_POSITION.formatted
			 	 		(Messages.POSITION.formatted(row, col)));
			}
			catch(IndexOutOfBoundsException e) {
				throw new CommandParseException("Not enough arguments");
			}
			return new ToggleLemmingCommand(col - 1, row);
		}
		
		return null;
	}

	@Override
	public void execute(GameModel game, GameView gameview) throws CommandExecuteException {
		game.stop(pos);
		game.update();
		gameview.showGame();
	}

}

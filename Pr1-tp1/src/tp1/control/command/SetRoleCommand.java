package tp1.control.command;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.LemmingRoleFactory;
import tp1.logic.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
	
	private String role;
	private Position pos;
	
	
	private static final String NAME = Messages.COMMAND_SET_ROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SET_ROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SET_ROLE_HELP;
	
	public SetRoleCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	public SetRoleCommand(String role, int col, int row) {
		super(NAME, SHORTCUT, DETAILS, HELP);
		this.role = role;
		this.pos = new Position(col, row);
	}
	
	public Command parse(String[] command) {
		if(matchCommand(command[0])) {
			char caracter = command[2].charAt(0);
			int row = (caracter - 'a');
			int col = Integer.parseInt(command[3]);
			return new SetRoleCommand(command[1], col - 1, row);
		}
		return null;
	}


	public void execute(GameModel game, GameView gameview) {
		LemmingRole r = LemmingRoleFactory.parse(role);
			if(r != null) {
				game.setRole(r, pos);
			}
		else gameview.showError(Messages.UNKNOWN_ROLE);
		game.update();
		gameview.showGame();
	}
	
	@Override
	protected String helpText() {
		String str;
		str = HELP + LemmingRoleFactory.roleHelp();
		return str;
	}
	
}

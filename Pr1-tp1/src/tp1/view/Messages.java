package tp1.view;

import tp1.util.MyStringUtils;

public class Messages {
	
	public static final String VERSION = "3.0";

	public static final String GAME_NAME = "Lemmings";

	public static final String USAGE = "Usage: %s [<level>]".formatted(GAME_NAME);

	public static final String WELCOME = String.format("%s %s%n", GAME_NAME, VERSION);

	public static final String LEVEL_NOT_A_NUMBER = "The level must be a number";

	public static final String LEVEL_NOT_A_NUMBER_ERROR = String.format("%s: %%s", LEVEL_NOT_A_NUMBER);

	public static final String CONFIGURED_LEVEL = "Level: %s";

	public static final String PROMPT = "Command > ";

	public static final String DEBUG = "[DEBUG] Executing: %s%n";

	public static final String ERROR = "[ERROR] Error: %s%n";

	public static final String LINE_SEPARATOR = System.lineSeparator();

	public static final String HELP_AVAILABLE_COMMANDS = "Available commands:";

	public static final String HELP_DETAILS_COMMAND_HELP_SEPARATOR = ": ";
	
	public static final String HELP_COMMAND_MARGIN = "   ";
	
	public static final String HELP_ROLE_MARGIN = "      ";
	
	public static final Character NEWLINE = '\n';

	/* @formatter:off */
	public static final String[] HELP_LINES = new String[] { "Available commands:",
			"[n]one | \"\": skips cycle",
			"[r]eset: start a new game",
			"[h]elp: print this help message",
			"[e]xit: end the execution of the game"};
	/* @formatter:on */

	public static final String HELP = String.join(LINE_SEPARATOR+"   ", HELP_LINES) + LINE_SEPARATOR;
	
	public static final String UNKNOWN_COMMAND = "Unknown command";
	
	public static final String UNKNOWN_ROLE = "Unknown Role";

	public static final String COMMAND_PARAMETERS_MISSING = "Missing parameters";

	public static final String COMMAND_INCORRECT_PARAMETER_NUMBER = "Incorrect parameter number";

	public static final String INVALID_POSITION = "Invalid position (%s, %s)";

	public static final String INVALID_GAME_OBJECT = String.format("Invalid object %n");

	public static final String INVALID_COMMAND = "Invalid command";

	public static final String NUMBER_OF_CYCLES = "Number of cycles:";

	public static final String REMAINING_LEMMINGS = "Remaining lemmings:";

	public static final String DEAD_LEMMINGS = "Dead lemmings:";

	public static final Object EXIT_LEMMINGS = "Lemmings exit door:";

	public static final String NUM_LEMMINGS = "Lemmings in board:";

	public static final String GAME_OVER = "Game over";

	public static final String PLAYER_QUITS = "Player leaves the game";

	public static final String PLAYER_WINS = "Player wins!";
	public static final String PLAYER_LOOSES = "Player looses...";

	public static final String POSITION = "(%s,%s)";
	
	public static final String SET_COMMAND_ERROR = "SetRoleCommand error (Incorrect position or no object in that position admits that role)";

//Commands
	public static final String COMMAND_NONE_NAME = "none";
	public static final String COMMAND_NONE_SHORTCUT = "n";
	public static final String COMMAND_NONE_DETAILS = "[n]one | \"\"";
	public static final String COMMAND_NONE_HELP = "user does not perform any action";
	
	public static final String COMMAND_EXIT_NAME = "exit";
	public static final String COMMAND_EXIT_SHORTCUT = "e";
	public static final String COMMAND_EXIT_DETAILS = "[e]xit";
	public static final String COMMAND_EXIT_HELP = "exits the game";

	public static final String COMMAND_HELP_NAME = "help";
	public static final String COMMAND_HELP_SHORTCUT = "h";
	public static final String COMMAND_HELP_DETAILS = "[h]elp";
	public static final String COMMAND_HELP_HELP = "print this help message";
	
	public static final String COMMAND_SET_ROLE_NAME = "setRole";
	public static final String COMMAND_SET_ROLE_SHORTCUT = "sr";
	public static final String COMMAND_SET_ROLE_DETAILS = "[s]et[R]ole ROLE ROW COL";
	public static final String COMMAND_SET_ROLE_HELP = "sets the lemming in position (ROW,COL) to role ROLE";
	
	public static final String COMMAND_LOAD_NAME = "load";
	public static final String COMMAND_LOAD_SHORTCUT = "l";
	public static final String COMMAND_LOAD_DETAILS = "[l]oad <fileName>";
	public static final String COMMAND_LOAD_HELP = "load the game configuration from text file <fileName>";
	
	public static final String COMMAND_RESET_NAME = "reset";
	public static final String COMMAND_RESET_SHORTCUT = "r";
	public static final String COMMAND_RESET_DETAILS = "[r]eset";
	public static final String COMMAND_RESET_HELP = "reset the game to initial configuration";
	
	public static final String COMMAND_TOGGLE_NAME = "toggLemming";
	public static final String COMMAND_TOGGLE_SHORTCUT = "tl";
	public static final String COMMAND_TOGGLE_DETAILS = "[t]oggle[L]emming";
	public static final String COMMAND_TOGGLE_HELP = "toggles a lemming";

//Roles
	
	public static final String ROLE_PARACHUTER_NAME = "Parachuter";
	public static final String ROLE_PARACHUTER_SHORTCUT = "p";
	public static final String ROLE_PARACHUTER_DETAILS = "[P]arachuter: Lemming falls with a parachute";
	
	public static final String ROLE_WALKER_NAME = "Walker";
	public static final String ROLE_WALKER_SHORTCUT = "w";
	public static final String ROLE_WALKER_DETAILS = "[W]alker: Lemming that walks";
	
	public static final String ROLE_DOWN_CAVER_NAME = "DownCaver";
	public static final String ROLE_DOWN_CAVER_SHORTCUT = "dc";
	public static final String ROLE_DOWN_CAVER_DETAILS = "[D]own [C]aver: Lemming caves downwards";
	
	public static final String ROLE_BLOCKER_NAME = "Blocker";
	public static final String ROLE_BLOCKER_SHORTCUT = "b";
	public static final String ROLE_BLOCKER_DETAILS = "Blocker: Lemming that blocks other Lemmings";
	
	public static final String ROLE_HORIZONTAL_CAVER_NAME = "HorizontalCaver";
	public static final String ROLE_HORIZONTAL_CAVER_SHORTCUT = "hc";
	public static final String ROLE_HORIZONTAL_CAVER_DETAILS = "[H]orizontal [C]aver: Lemming that caves horizontally";
	
	public static final String ROLE_CAVER_NAME = "Caver";
	public static final String ROLE_CAVER_SHORTCUT = "c";
	public static final String ROLE_CAVER_DETAILS = "[C]aver+dir: Lemming that caves following a \"dir\" direction";
	
	public static final String ROLE_DRONE_NAME = "Drone";
	public static final String ROLE_DRONE_SHORTCUT = "d";
	public static final String ROLE_DOWN_DRONE_DETAILS = "[D]roneRole<dir1, dir2, ... , dirN>";
	
//Symbols
	public static final String EMPTY = "";
	public static final String WALL = MyStringUtils.repeat("▓",ConsoleView.CELL_SIZE);
	public static final String METAL_WALL = MyStringUtils.repeat("X",ConsoleView.CELL_SIZE);;
	public static final String EXIT_DOOR = "🚪";
	public static final String LEMMING_RIGHT = "B";
	public static final String LEMMING_LEFT = "ᗺ";
	public static final String PARACHUTE = "🪂";
	public static final String LEMMING_DOWN_CAVER = "´･ω･`";
	public static final String LEMMMING_BLOCKER = "T";
	public static final String LEMMING_HORIZONTAL_CAVER = "⬅️➡️";

	

}

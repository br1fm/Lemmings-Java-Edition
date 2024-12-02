package tp1.exceptions;

public class CommandExecute extends CommandException{
	
	public CommandExecute() { super(); }
	
	public CommandExecute(String message){ super(message); };
	
	public CommandExecute(String message, Throwable cause){
	    super(message, cause);
	}
	public CommandExecute(Throwable cause){ super(cause); }
	
	public CommandExecute(String message, Throwable cause,
			  boolean enableSuppression, boolean writeableStackTrace){
	    super(message, cause, enableSuppression, writeableStackTrace);
	}

}

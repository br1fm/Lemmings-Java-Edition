package tp1.exceptions;

public class CommandParse extends CommandException{
	
	public CommandParse() { super(); }
	
	public CommandParse(String message){ super(message); };
	
	public CommandParse(String message, Throwable cause){
	    super(message, cause);
	}
	public CommandParse(Throwable cause){ super(cause); }
	
	public CommandParse(String message, Throwable cause,
			  boolean enableSuppression, boolean writeableStackTrace){
	    super(message, cause, enableSuppression, writeableStackTrace);
	}

}

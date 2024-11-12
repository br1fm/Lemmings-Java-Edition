package tp1.logic.lemmingRoles;
import tp1.logic.gameobjects.Lemming;

public interface LemmingRole {
	
    public void start(Lemming lemming);
    public void play(Lemming lemming);
    public String getIcon(Lemming lemming);
    public void manageFall(Lemming lemming);
    public boolean manageLanding(Lemming lemming);
    public String helpText();
    public LemmingRole parse(String role);
    
}

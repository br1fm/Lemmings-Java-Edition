package tp1.logic.lemmingRoles;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public interface LemmingRole {
	
    public void start(Lemming lemming);
    public void play(Lemming lemming);
    public String getIcon(Lemming lemming);
    public String getName();
    public String getShortcut();
    public String getDetails();
    
    public String helpText();
    public LemmingRole parse(String role);
    
    public boolean receiveInteraction(GameItem other, Lemming owner);
    public boolean interactWith(Lemming receiver, Lemming owner);
    public boolean interactWith(Wall wall, Lemming owner);
    public boolean interactWith(ExitDoor door, Lemming owner);
    boolean equals(LemmingRole other_role);
}

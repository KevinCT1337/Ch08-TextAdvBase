import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    
    private ArrayList<Item> inventory;
    private static final int DEFAULT_MAX_WEIGHT_CAP = 10;
    private int maxWeightCapacity;
    
    private Room currentRoom;
    
    
    public Player(Room startingRoom)
    {
        maxWeightCapacity = DEFAULT_MAX_WEIGHT_CAP;
        currentRoom = startingRoom;
    }
    
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    
    public void setCurrentRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }
    
    public void pickUpItem(Item itemPickingUp)
    {
        
    }
    
    public void dropItem()
    {
        
    }
    
    
}
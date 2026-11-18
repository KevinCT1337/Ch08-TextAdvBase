import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author Kevin Cox-Torrelio
 * @version 11-17-2026
 */
public class Player
{
    
    private ArrayList<Item> inventory;
    private static final int DEFAULT_MAX_WEIGHT = 10;
    private int maxWeightCapacity;
    
    private Room currentRoom;
    
    
    public Player(Room startingRoom)
    {
        maxWeightCapacity = DEFAULT_MAX_WEIGHT;
        currentRoom = startingRoom;
        inventory = new ArrayList<Item>();
    }
    
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    
    public void setCurrentRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }
    
    private int getCurrentWeight()
    {
        int totalWeight = 0;
        
        Iterator<Item> iterator = inventory.iterator();
        
        
        while (iterator.hasNext())
        {
            Item item = iterator.next();
            totalWeight += item.getWeight();
        }
        
        return totalWeight;
    }
    
    public void printInventory()
    {
        String desc = "Your inventory: ";
        
        Iterator<Item> iterator = inventory.iterator();
        
        if (iterator.hasNext()){
            while (iterator.hasNext()) {
                Item item = iterator.next();
                desc = desc + item.getDescription() + " (W: " + item.getWeight() + ")";
                if (iterator.hasNext()) {
                    desc = desc + ", ";
                }
            }
        } else {
            desc = desc + "nothing";
        }
        
        desc += "\nTotal Weight: " + getCurrentWeight() + "\nMaximum Weight Cap: " + maxWeightCapacity;
        
        System.out.println(desc);
    }
    
    
    
    /**
     * Method to have the player pick up the specified item
     * 
     * 
     */
    public void pickUpItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        
        String itemName = command.getSecondWord().toLowerCase();
        ArrayList<Item> itemsInRoom = currentRoom.getItemsInRoom();
        
        Iterator<Item> iterator = itemsInRoom.iterator();
        
        if (!iterator.hasNext())
        {
            System.out.println("There is nothing to pick up here.");
            return;
        }
        
        Item itemFound = null;
        
        while (iterator.hasNext())
        {
            Item item = iterator.next();
            
            // If the names are the same
            if (item.getName().toLowerCase().equals(itemName)) 
            {
                itemFound = item;
                break;
            }
        }
        
        if (itemFound != null)
        {
            if (itemFound.getPickableState() == false) 
            {
                System.out.println("The " + itemName + " is impossible to pick up...");
                return;
            } 
            
            if (getCurrentWeight() + itemFound.getWeight() > maxWeightCapacity) {
                System.out.println("You're carrying too much weight to pick up that " + itemFound.getName());
            } else {
                inventory.add(itemFound);
                System.out.println("You picked up a: " + itemFound.getName());
                currentRoom.removeItem(itemFound);
            }
            
        } else {
            System.out.println("Doesn't seem like the " + itemName + " is here...");
        }
        
    }
    
    
    /**
     * Method to have the player drop the specified item
     * 
     */
    public void dropItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        
        String itemName = command.getSecondWord().toLowerCase();
        
        Iterator<Item> iterator = inventory.iterator();
        
        if (!iterator.hasNext())
        {
            System.out.println("There is nothing in your inventory to drop.");
            return;
        }
        
        Item itemFound = null;
        
        while (iterator.hasNext())
        {
            Item item = iterator.next();
            
            // If the names are the same
            if (item.getName().toLowerCase().equals(itemName)) 
            {
                itemFound = item;
                break;
            }
        }
        
        if (itemFound != null)
        {
            System.out.println("You dropped a: " + itemFound.getName());
            currentRoom.addItem(itemFound);
            inventory.remove(itemFound);
        } else {
            System.out.println("Doesn't seem like you have the " + itemFound.getName() + " to drop.");
        }
        
    }
    
    
}
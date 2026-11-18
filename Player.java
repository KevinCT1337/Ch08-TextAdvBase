import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * This class handles player specific actions such as picking and dropping items, eating items,
 * methods to deal with the room the player is in, and dealing with the player's inventory.
 *
 * @author Kevin Cox-Torrelio
 * @version 11-17-2026
 */
public class Player
{
    private static final int DEFAULT_MAX_WEIGHT = 10;
    private static final int MAGIC_COOKIE_WT_INCREMENT_BY = 5;
    
    private ArrayList<Item> inventory;
    
    private int maxWeightCapacity;
    
    private Room currentRoom;
    
    /**
     * Construtor for objects of the Player class
     * 
     * @param startingRoom The initial room the player starts in
     */
    public Player(Room startingRoom)
    {
        maxWeightCapacity = DEFAULT_MAX_WEIGHT;
        currentRoom = startingRoom;
        inventory = new ArrayList<Item>();
    }
    
    /**
     * Getter method that gets the current room the player is in
     * 
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    /**
     * Setter method to set the new room the player moved to
     * 
     */
    public void setCurrentRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }
    
    /**
     * Getter method that returns the total weight of all items the player is carrying
     * 
     * @return The total weight of items carried
     */
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
    
    
    /**
     * Neatly prints out the inventory of the player, their total weight and max weight
     * 
     */
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
     * Method that has the player eat an item from the command being ran
     * 
     * @param command The command the player initially ran to process on
     */
    public void eatItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Eat what?");
            return;
        }
        
        String itemName = command.getSecondWord().toLowerCase();
        Iterator<Item> iterator = inventory.iterator();
        
        if (!iterator.hasNext())
        {
            System.out.println("There is nothing to eat in your inventory.");
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
            if (itemFound.getName().equals("cookie"))
            {
                maxWeightCapacity += MAGIC_COOKIE_WT_INCREMENT_BY;
                System.out.println("Wow, that magic cookie increased your max capacity by: " + MAGIC_COOKIE_WT_INCREMENT_BY);
            }
        } else {
            System.out.println("You don't have a " + itemFound + " to eat.");            
        }
        
        
    }
    
    /**
     * Method to have the player pick up a specified item from the command being ran
     * 
     * @param command The command the player initially ran to process on
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
     * Method to have the player drop a specified item from the command being ran
     * 
     * @param command The command the player initially ran to process on
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
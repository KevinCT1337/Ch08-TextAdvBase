
/**
 * This class handles the creation of items the player can interact with and
 * can be stored in rooms. Includes the description and weight of the item
 *
 * @author Kevin Cox-Torrelio
 * @version 2026-11-02
 */
public class Item
{
    private String description;
    private int weight;
    private String name;
    private boolean canBePickedUp;
    private static final boolean DEFAULT_PICKABLE_STATE = true;

    /**
     * Construtor for Item class if no pickable state is defined
     * 
     * @param initialName The name to set the item to
     * @param initialDesc The description to set the item to
     * @param initialWeight The weight to set the item to
     */
    public Item(String initialName, String initialDesc, int initialWeight)
    {
        this(initialName,initialDesc,initialWeight, DEFAULT_PICKABLE_STATE);
    }
    
    
    /**
     * Constructor for objects of the Item class
     * 
     * @param initialName The name to set the item to
     * @param initialDesc The description to set the item to
     * @param initialWeight The weight to set the item to
     * @param pickableState The initial state to set the item to on whether it can be picked up or not
     */
    public Item(String initialName, String initialDesc, int initialWeight, boolean pickableState)
    {
        description = initialDesc;
        weight = initialWeight;
        name = initialName;
        canBePickedUp = pickableState;
    }
    
    /**
     * Gets the state of the item if it's able to be picked up by a player
     * 
     * @return The state of the item being able to be picked up, true is yes, false is no
     */
    public boolean getPickableState()
    {
        return canBePickedUp;
    }
    
    
    /**
     * Gets the stored name of the item
     * 
     * @return Name of the item
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the stored description of the item
     * 
     * @return Description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    
    /**
     * Gets the stored weight of the item
     * 
     * @return Weight of the item
     */
    public int getWeight()
    {
        return weight;
    }
}
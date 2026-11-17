
/**
 * Item Class
 * 
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

    
    public Item(String initialName, String initialDesc, int initialWeight)
    {
        this(initialName,initialDesc,initialWeight, DEFAULT_PICKABLE_STATE);
    }
    
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String initialName, String initialDesc, int initialWeight, boolean pickableState)
    {
        description = initialDesc;
        weight = initialWeight;
        name = initialName;
        canBePickedUp = pickableState;
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
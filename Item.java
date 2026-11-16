
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
    private String itemDescription;
    private int itemWeight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String initialDesc, int initialWeight)
    {
        itemDescription = initialDesc;
        itemWeight = initialWeight;
    }
    
    /**
     * Gets the stored description of the item
     * 
     * @return Description of the item
     */
    public String getDescription()
    {
        return itemDescription;
    }
    
    
    /**
     * Gets the stored weight of the item
     * 
     * @return Weight of the item
     */
    public int getWeight()
    {
        return itemWeight;
    }
}
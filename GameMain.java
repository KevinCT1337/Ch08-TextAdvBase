
/**
 * Handles the initialization of creating a Game object and begins playing the game
 *
 * @author Kevin Cox-Torrelio
 * @version 2026-11-17
 */
public class GameMain
{
    
    private static Game game;
    
    /**
     * Main method which initializes a Game object and plays
     * 
     */
    public static void main(String[] args) {
        game = new Game();
        game.play();
    }
    
    
}
import java.awt.*;

public class Main {

    public static void main(String[] args){
        Window gameWindow = new Window("Clicker Game", 600, 300);
        Game game = new Game(gameWindow);
    }
}

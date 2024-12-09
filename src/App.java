import view.game.GameFrame;

public class App {

    private static GameFrame gameFrame;

    public static void main(String[] args) {
        gameFrame = new GameFrame();
    }

    public static GameFrame getGameFrame() {
        return gameFrame;
    }
}

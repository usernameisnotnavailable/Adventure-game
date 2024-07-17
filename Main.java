import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    final static GameMap gameMap = new GameMap();

public static void main(String[] args) {

    gameMap.randomMapGenerator();
    // gameMap.fillCreatures();

    Player player = new Player("John Wick", 100, 20, 10, new Weapon("bicska", 10), new Shield("fatönk", 10), new Spell("kis láng", 10, 10));
    List<Boss> bosses = new ArrayList<>();
    bosses.add(new Boss());
    bosses.add(new Boss());
    bosses.add(new Boss());
    bosses.add(new Boss());
    bosses.add(new Boss());
    bosses.add(new Boss());

    Board board = new Board(player, bosses);
    JFrame frame = new JFrame("Your Application");

    frame.add(board);

    frame.setSize(1200, 780);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    Game game = new Game(player, board, bosses);
    game.run();
    frame.pack();
    frame.addKeyListener(board);


}
}
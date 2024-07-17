import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board extends JComponent implements KeyListener {

    private int eventHandler;
    public static final int cellWidth = 30;
    public static final int cellHeight = 30;
    private final Player player;
    private final List<Boss> bosses;
    private static boolean drawn = false;



    public Board(Player player, List<Boss> bosses) {
        this.bosses = bosses;
        int WIDTH = 1450;
        int HEIGHT = 750;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        this.player = player;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        String minionIcon = "Images/Minion.png";
        drawTheMap(graphics);
        drawAi(graphics);
        drawPlayer(graphics);
    }


    public void drawTheMap(Graphics graphics) {
        HashMap<Integer, String> charAndIcon = new HashMap<>(Map.of(
                0, "images/floor.png",
                1, "images/tile30.png",
                2, "images/Shadow.png"
        ));

            for (int i = 0; i < GameMap.mapHeight; i++) {
                for (int j = 0; j < GameMap.mapWidth; j++) {
                    if (GameMap.locations[i][j] == 0) {
                        int x = j * cellWidth;
                        int y = i * cellHeight;
                        PositionedImage image = new PositionedImage(charAndIcon.get(0), x, y);
                        image.draw(graphics);
                    } else if (GameMap.locations[i][j] == 1) {
                        int x = j * cellWidth;
                        int y = i * cellHeight;
                        PositionedImage image = new PositionedImage(charAndIcon.get(1), x, y);
                        image.draw(graphics);
                    } else if(GameMap.locations[i][j] == 2){
                        int x = j * cellWidth;
                        int y = i * cellHeight;
                        PositionedImage image = new PositionedImage(charAndIcon.get(2), x, y);
                        image.draw(graphics);
                    }
                }
            }

    }

    private void drawPlayer(Graphics graphics){
        String playerIcon = "Images/Player.png";
        int y = player.getPositionY() * cellHeight;
        int x = player.getPositionX() * cellWidth;
        PositionedImage image = new PositionedImage(playerIcon, x, y);
        image.draw(graphics);
    }

    private void drawAi(Graphics graphics){
        String bossIcon = "Images/Minion.png";
        for (Boss boss: bosses) {
            int x = boss.getPositionX() * cellWidth;
            int y = boss.getPositionY() * cellHeight;
            PositionedImage image = new PositionedImage(bossIcon, x, y);
            image.draw(graphics);
        }
    }



    protected void drawSpell(int x, int y){
        String fireball = "Images/fireball1.png";
        PositionedImage image = new PositionedImage(fireball, x, y);
        image.draw(this.getGraphics());
    }
    protected void drawSingleTile(int x, int y){
        String tile = "images/shadow.png";
        PositionedImage image = new PositionedImage(tile, x, y);
        image.draw(this.getGraphics());

    }

    public void boardRepaint(){
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_0){
            eventHandler = 5;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            player.setDirection(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            player.setDirection(3);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            player.setDirection(4);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            player.setDirection(2);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}




import java.util.Random;

public class AISpell implements Runnable {
    Board board;
    Boss boss;
    Player player;
    Random random = new Random();

    public AISpell(Board board, Boss boss, Player player) {
        this.board = board;
        this.boss = boss;
        this.player = player;
        drawSpell();
    }

    @Override
    public void run() {
        switch (0) {
            case 0: //spell();
                break;
            case 1: //sleep();
                break;
            case 2: //chase();
                break;
        }
    }


    private void drawSpell() {
        int bossPositionX = boss.getPositionX();
        int bossPositionY = boss.getPositionY();
        int playerPositionX = player.getPositionX();
        int playerPositionY = player.getPositionY();
        int bossDirection = boss.getDirection();
        int startingPoint;
        int destination;

        switch (bossDirection) {
            case 4:
                startingPoint = bossPositionX * Board.cellWidth;
                destination = playerPositionX * Board.cellWidth;
                for (int x = startingPoint; x >= destination; x -= 4) {
                    board.drawSpell(x, bossPositionY * Board.cellHeight);
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

            case 2:
                startingPoint = bossPositionX * Board.cellWidth;
                destination = playerPositionX * Board.cellWidth;
                for (int x = startingPoint; x <= destination; x += 4) {
                    board.drawSpell(x, bossPositionY * Board.cellHeight);
                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                break;
        }
    }

    /*
directions:
1 - up
2 - right
3 - down
4 - left
 */
}
